import {
  Body,
  Controller,
  Post,
  UsePipes,
  ValidationPipe,
} from '@nestjs/common';
import { UsersService } from './users.service';
import { newUserDto } from './Validator/newUserValidator';

@Controller('users')
export class UsersController {
  constructor(private readonly usersService: UsersService) {}
  @Post('signup')
  @UsePipes(new ValidationPipe({ transform: true }))
  async SignUp(@Body() body: newUserDto) {
    console.log(newUserDto);

    const newUser = await this.usersService.InsertUser(
      body.username,
      body.password,
    );
    console.log(newUser);
    return {
      status: 'ok',
      newUser,
    };
  }
}
