import appConfig from 'src/Config/app.config';

export const jwtConstants = {
  secret: appConfig().JWT_SECRET,
};
