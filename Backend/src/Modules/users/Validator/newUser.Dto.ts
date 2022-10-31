import {
  IsEmail,
  IsNotEmpty,
  IsOptional,
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

export class newUserDto {
  @IsNotEmpty()
  @IsEmail()
  email: string;

  @IsNotEmpty()
  frist_name: string;

  @IsOptional()
  middle_name: string;

  @IsOptional()
  last_name: string;

  @IsNotEmpty()
  @MinLength(6)
  @MaxLength(14)
  password: string;

  @Validate(CustomMatchPasswords, ['password'])
  passwordConfirm: string;

  Role = 'user';
}
