import { ExtractJwt, Strategy } from 'passport-jwt';
import { PassportStrategy } from '@nestjs/passport';
import { Injectable } from '@nestjs/common';
import appConfig from 'src/Config/app.config';
import { UsersService } from 'src/Modules/users/users.service';
import { Request } from 'express';

type jwtPayload = {
  userId: string;
  email: string;
};
@Injectable()
export class JwtStrategyRefreshToken extends PassportStrategy(
  Strategy,
  'jwt-refresh',
) {
  constructor(private readonly userservice: UsersService) {
    super({
      jwtFromRequest: ExtractJwt.fromAuthHeaderAsBearerToken(),
      ignoreExpiration: false,
      secretOrKey: appConfig().JWT_REFRESH_SECRET,
    });
  }

  async validate(req: Request, payload: jwtPayload) {
    console.log(req);
    const user = await this.userservice.getUserById(payload.userId);
    return {
      user,
      //   refreshToken,
    };
  }
}
