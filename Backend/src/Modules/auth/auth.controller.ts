import {
  Body,
  Controller,
  Post,
  UsePipes,
  ValidationPipe,
  UseGuards,
  Get,
} from '@nestjs/common';
import { AuthService } from '../auth/auth.service';
import { User } from '../auth/Decorators/User.Decorator';
import { JwtAccessTokenGuard } from './Gaurds/jwtAccesssToken.auth.gaurd';
import { NewUserDto } from '../users/Dto/newUser.Dto';
import { UsersService } from '../users/users.service';
import AuthDto from './Dto/auth.dto';
import {
  ApiBadRequestResponse,
  ApiCreatedResponse,
  ApiTags,
} from '@nestjs/swagger';
import { User as UserType } from '@prisma/client';
// import { JwtRefreshTokenGuard } from './Gaurds/jwtRefreshToken.auth.gard';

@Controller()
@ApiTags('Auth')
export class AuthCoontroller {
  constructor(
    private readonly usersService: UsersService,
    private readonly authService: AuthService,
  ) {}
  @ApiCreatedResponse({ description: 'User is successfully added' })
  @ApiBadRequestResponse({ description: 'User Already Exist' })
  @Post('signup')
  @UsePipes(new ValidationPipe({ transform: true }))
  async SignUp(@Body() body: NewUserDto) {
    return await this.authService.signUp(body);
  }
  @Post('login')
  @UsePipes(new ValidationPipe({ transform: true }))
  async login(@Body() body: AuthDto) {
    return this.authService.signIn(body);
  }
  @UseGuards(JwtAccessTokenGuard)
  @Get('profile')
  async profile(@User() user: UserType) {
    return {
      user: user,
    };
  }
  // @UseGuards(JwtAccessTokenGuard)
  // @Get('logout')
  // async logout(@User() user: UserDocument) {
  //   return await this.authService.logout(user.id);
  // }

  // @UseGuards(JwtRefreshTokenGuard)
  // @Get('refresh')
  // async refresh(@Req() req, @User() user: UserDocument) {
  //   return this.authService.updateRefreshToken(user.id, req.refreshToken);
  // }
}
