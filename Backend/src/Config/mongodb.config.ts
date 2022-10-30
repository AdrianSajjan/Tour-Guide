import { MongooseModuleAsyncOptions } from '@nestjs/mongoose';
import appConfig from './app.config';

const mongoDBConfig: MongooseModuleAsyncOptions = {
  useFactory: () => ({
    uri: appConfig().MONGODB_URL,
  }),
};
export default mongoDBConfig;
