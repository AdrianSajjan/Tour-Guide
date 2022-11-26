import {
  BadRequestException,
  ForbiddenException,
  forwardRef,
  Inject,
  Injectable,
} from '@nestjs/common';
import { JwtService } from '@nestjs/jwt';
import { UsersService } from '../users/users.service';
import { NewUserDto } from '../users/Dto/newUser.Dto';
import { hash, compare } from 'bcrypt';
import appConfig from 'src/Config/app.config';
import AuthDto from './Dto/auth.dto';
import { User } from '@prisma/client';

@Injectable()
export class AuthService {
  constructor(
    @Inject(forwardRef(() => UsersService))
    private readonly userService: UsersService,
    private readonly jwtService: JwtService,
  ) {}

  async signUp(createUserDto: NewUserDto): Promise<any> {
    //?Check Weather User exist or not
    const userExist = await this.userService.findByEmail(createUserDto.email);
    if (userExist) {
      throw new BadRequestException('User Already Exist');
    }
    //?Hash The password
    const hashedPassword = await this.hashData(createUserDto.password);
    //?Create new user
    const newUser = await this.userService.InsertUser({
      ...createUserDto,
      password: hashedPassword,
    });
    //*Generate Access Token and refresh token
    const tokens = await this.getTokens(newUser.id, newUser.email);
    await this.updateRefreshToken(newUser.id, tokens.refreshToken);
    return this.sentdResponseWithToken(newUser, tokens);
  }
  async hashData(password: string) {
    return await hash(password, appConfig().SALTROUNDS);
  }
  async updateRefreshToken(userId: string, refreshToken: string) {
    const hashedRefeshToken = await this.hashData(refreshToken);
    await this.userService.updateUserById(userId, {
      refreshToken: hashedRefeshToken,
    });
  }
  async signIn(data: AuthDto) {
    //*Check user is exist
    const existUser = await this.userService.findByEmail(data.email);
    if (!existUser) {
      throw new BadRequestException('User Does not exist');
    }
    const passwordMatch = await compare(data.password, existUser.password);
    if (!passwordMatch) {
      throw new BadRequestException('Password is wrong');
    }
    const tokens = await this.getTokens(existUser.id, existUser.email);
    await this.updateRefreshToken(existUser.id, tokens.refreshToken);
    return this.sentdResponseWithToken(existUser, tokens);
  }

  async logout(userId: string) {
    this.userService.updateUserById(userId, { refreshToken: null });
  }

  async refreshTokens(userId: string, refreshToken: string) {
    //*Get user by id
    const user = await this.userService.getUserById(userId);

    //*Check weather user and refresh token exist
    if (!user || !user.refreshToken)
      throw new ForbiddenException('Access Denied');

    //*Check refresh token validity
    const refreshTokenMatches = await compare(user.refreshToken, refreshToken);
    if (!refreshTokenMatches) throw new ForbiddenException('Access Denied');
    const tokens = await this.getTokens(user.id, user.email);
    await this.updateRefreshToken(user.id, tokens.refreshToken);
    return this.sentdResponseWithToken(user, tokens);
  }

  async getTokens(userId: string, email: string) {
    const [accessToken, refreshToken] = await Promise.all([
      this.jwtService.signAsync(
        {
          userId,
          email,
        },
        {
          secret: appConfig().JWT_SECRET,
          expiresIn: '15m',
        },
      ),
      this.jwtService.signAsync(
        {
          userId,
          email,
        },
        {
          secret: appConfig().JWT_REFRESH_SECRET,
          expiresIn: '7d',
        },
      ),
    ]);

    return {
      accessToken,
      refreshToken,
    };
  }
  sentdResponseWithToken(
    user: User,
    tokens: { accessToken: string; refreshToken: string },
  ) {
    return {
      user,
      accessToken: tokens.accessToken,
    };
  }
}
