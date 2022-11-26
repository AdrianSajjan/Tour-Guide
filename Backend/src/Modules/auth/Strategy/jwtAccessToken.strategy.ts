import { ExtractJwt, Strategy } from 'passport-jwt';
import { PassportStrategy } from '@nestjs/passport';
import { Injectable } from '@nestjs/common';
import appConfig from 'src/Config/app.config';
import { UsersService } from 'src/Modules/users/users.service';

type jwtPayload = {
  userId: string;
  email: string;
};
@Injectable()
export class JwtStrategyAccessToken extends PassportStrategy(Strategy, 'jwt') {
  constructor(private readonly userservice: UsersService) {
    super({
      jwtFromRequest: ExtractJwt.fromAuthHeaderAsBearerToken(),
      ignoreExpiration: false,
      secretOrKey: appConfig().JWT_SECRET,
    });
  }

  async validate(payload: jwtPayload) {
    const user = await this.userservice.getUserById(payload.userId);
    return user;
  }
}
