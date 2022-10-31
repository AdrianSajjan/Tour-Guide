import { JwtModuleAsyncOptions } from '@nestjs/jwt';
import appConfig from './app.config';

const jwtConfig: JwtModuleAsyncOptions = {
  useFactory: () => ({
    secret: appConfig().JWT_SECRET,
    signOptions: {
      expiresIn: appConfig().JWT_EXPIRES_IN,
    },
  }),
};
export default jwtConfig;
