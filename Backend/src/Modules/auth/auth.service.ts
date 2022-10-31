import {
  forwardRef,
  Inject,
  Injectable,
  NotAcceptableException,
} from '@nestjs/common';
import { User } from '../users/users.model';
import { JwtService } from '@nestjs/jwt';
import { UsersService } from '../users/users.service';

@Injectable()
export class AuthService {
  constructor(
    @Inject(forwardRef(() => UsersService))
    private readonly userService: UsersService,
    private readonly jwtService: JwtService,
  ) {}
  async validateUser(username: string, password: string): Promise<User> {
    const getUser = await this.userService.getUser(username);
    if (!getUser || !(await getUser.comarePassword(password))) {
      throw new NotAcceptableException('user and password is wrong');
    }
    return getUser;
  }
  generateToken(user: User) {
    const payload = { email: user.email, id: user.id };
    return this.jwtService.sign(payload);
  }
}
