import {
  Body,
  Controller,
  Post,
  UsePipes,
  ValidationPipe,
  Request,
  UseGuards,
  Get,
} from '@nestjs/common';
import { AuthService } from '../auth/auth.service';
import { JwtAuthGuard } from '../auth/Gaurds/jwt.auth.gaurd';
import { LocalAuthGuard } from '../auth/Gaurds/local.auth.guard';
import { UsersService } from './users.service';
import { newUserDto } from './Validator/newUser.Dto';

@Controller('users')
export class UsersController {
  constructor(
    private readonly usersService: UsersService,
    private readonly authService: AuthService,
  ) {}
  @Post('signup')
  @UsePipes(new ValidationPipe({ transform: true }))
  async SignUp(@Body() body: newUserDto) {
    const newUser = await this.usersService.InsertUser(body);
    return {
      status: 'ok',
      newUser,
      token: this.authService.generateToken(newUser),
    };
  }
  @UseGuards(LocalAuthGuard)
  @Post('login')
  async login(@Request() req) {
    return {
      User: req.user,
      msg: 'user loggedin',
      token: this.authService.generateToken(req.user),
    };
  }
  @UseGuards(JwtAuthGuard)
  @Get('profile')
  async profile(@Request() req) {
    return {
      user: req.user,
    };
  }
}
