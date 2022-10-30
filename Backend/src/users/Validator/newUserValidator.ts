import { IsNotEmpty, MaxLength, MinLength } from 'class-validator';

export class newUserDto {
  @IsNotEmpty()
  @MinLength(4)
  username: string;

  @IsNotEmpty()
  @MinLength(6)
  @MaxLength(14)
  password: string;
}
