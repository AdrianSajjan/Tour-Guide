import { ApiProperty } from '@nestjs/swagger';
import {
  IsEmail,
  IsNotEmpty,
  MaxLength,
  MinLength,
  Validate,
  ValidationArguments,
  ValidatorConstraint,
  ValidatorConstraintInterface,
} from 'class-validator';

//Password Match Validaror
@ValidatorConstraint({ name: 'CustomMatchPasswords', async: false })
export class CustomMatchPasswords implements ValidatorConstraintInterface {
  validate(password: string, args: ValidationArguments) {
    if (password !== (args.object as any)[args.constraints[0]]) return false;
    return true;
  }

  defaultMessage() {
    return 'Passwords do not match!';
  }
}

export class NewUserDto {
  @ApiProperty({
    example: 'John@gmail.com',
  })
  @IsNotEmpty()
  @IsEmail()
  email: string;

  @ApiProperty({
    example: 'John Doe',
  })
  @IsNotEmpty()
  name: string;

  @ApiProperty({
    example: 'Password@123',
  })
  @IsNotEmpty()
  @MinLength(6)
  @MaxLength(14)
  password: string;

  @ApiProperty({
    example: 'Password@123',
  })
  @Validate(CustomMatchPasswords, ['password'])
  passwordConfirm: string;

  refreshToken: string;

  Role = 'user';
}
