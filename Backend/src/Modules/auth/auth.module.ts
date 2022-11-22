import { forwardRef, Module } from '@nestjs/common';
import { JwtModule } from '@nestjs/jwt';
import { PassportModule } from '@nestjs/passport';
import jwtConfig from 'src/Config/jwt.config';
import { UsersModule } from '../users/users.module';
import { AuthCoontroller } from './auth.controller';
import { AuthService } from './auth.service';
import { JwtStrategyAccessToken } from './Strategy/jwtAccessToken.strategy';
import { JwtStrategyRefreshToken } from './Strategy/jwtRefreshToken.strategy';

@Module({
  imports: [
    forwardRef(() => UsersModule),
    PassportModule,
    JwtModule.registerAsync(jwtConfig),
  ],
  providers: [AuthService, JwtStrategyAccessToken, JwtStrategyRefreshToken],
  controllers: [AuthCoontroller],
  exports: [AuthService],
})
export class AuthModule {}
