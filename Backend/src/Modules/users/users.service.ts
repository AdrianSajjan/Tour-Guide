import {
  HttpException,
  HttpStatus,
  Injectable,
  NotFoundException,
} from '@nestjs/common';
import { InjectModel } from '@nestjs/mongoose';
import { Model } from 'mongoose';
import { UserDocument } from './users.model';
import { UpdateUserDto } from './Dto/updateUser.dto';
import { NewUserDto } from './Dto/newUser.Dto';

@Injectable()
export class UsersService {
  constructor(
    @InjectModel('user') private readonly userModel: Model<UserDocument>,
  ) {}
  async InsertUser(newUserDto: NewUserDto) {
    const newUser = new this.userModel(newUserDto);
    await newUser.save();
    return newUser;
  }
  async getUser(email: string): Promise<UserDocument> {
    const user = await this.userModel.findOne({ email });
    if (!user) {
      throw new HttpException('User Not Found', HttpStatus.NOT_FOUND);
    }
    return user;
  }
  async getUserById(id: string): Promise<UserDocument> {
    const user = await this.userModel.findById(id);
    if (!user) {
      throw new NotFoundException();
    }
    return user;
  }
  async findAllUsers(): Promise<UserDocument[]> {
    return await this.userModel.find({});
  }
  async updateUserById(
    id: string,
    updateUserDto: UpdateUserDto,
  ): Promise<UserDocument> {
    return await this.userModel.findByIdAndUpdate(id, updateUserDto, {
      new: true,
    });
  }
  async removeUserById(id: string): Promise<UserDocument> {
    return await this.userModel.findByIdAndDelete(id);
  }
  async findByEmail(email: string): Promise<UserDocument> {
    return await this.userModel.findOne({ email });
  }
}
