import { Injectable } from '@nestjs/common';
import { InjectModel } from '@nestjs/mongoose';
import { Model } from 'mongoose';
import { User } from './users.model';

@Injectable()
export class UsersService {
  constructor(@InjectModel('user') private readonly userModel: Model<User>) {}
  async InsertUser(username: string, password: string) {
    console.log(username, password);
    const newUser = new this.userModel({
      username,
      password,
    });
    await newUser.save();
    return newUser;
  }
}
