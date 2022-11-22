import { PartialType } from '@nestjs/mapped-types';
import { NewUserDto } from './newUser.Dto';

export class UpdateUserDto extends PartialType(NewUserDto) {}
