import {
  HttpException,
  HttpStatus,
  Injectable,
  NotFoundException,
} from '@nestjs/common';
import { UpdateUserDto } from './Dto/updateUser.dto';
import { NewUserDto } from './Dto/newUser.Dto';
import { PrismaService } from '../prisma/prisma.service';
import { User } from '@prisma/client';
@Injectable()
export class UsersService {
  constructor(private readonly prisma: PrismaService) {}
  async InsertUser(newUserDto: NewUserDto): Promise<User> {
    try {
      const newUserPris = await this.prisma.user.create({ data: newUserDto });
      return newUserPris;
    } catch (error) {
      console.log(error);
    }
  }
  async getUser(email: string): Promise<User> {
    const user = await this.prisma.user.findFirst({ where: { email: email } });
    if (!user) {
      throw new HttpException('User Not Found', HttpStatus.NOT_FOUND);
    }
    return user;
  }
  async getUserById(id: string): Promise<User> {
    const user = await this.prisma.user.findFirst({ where: { id: id } });
    if (!user) {
      throw new NotFoundException();
    }
    return user;
  }
  async findAllUsers(): Promise<User[]> {
    return await this.prisma.user.findMany();
  }
  async updateUserById(
    id: string,
    updateUserDto: UpdateUserDto,
  ): Promise<User> {
    return await this.prisma.user.update({
      where: { id: id },
      data: updateUserDto,
    });
  }
  async removeUserById(id: string): Promise<User> {
    return await this.prisma.user.delete({ where: { id } });
  }
  async findByEmail(email: string): Promise<User> {
    return await this.prisma.user.findFirst({ where: { email } });
  }
}
