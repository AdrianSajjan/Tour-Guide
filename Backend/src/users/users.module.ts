import * as bcrypt from 'bcrypt';
import { Module } from '@nestjs/common';
import { UsersService } from './users.service';
import { UsersController } from './users.controller';
import { AsyncModelFactory, MongooseModule } from '@nestjs/mongoose';
import { UserSchema } from './users.model';

const featureOption: AsyncModelFactory[] = [
  {
    name: 'user',
    useFactory: () => {
      const schema = UserSchema;
      schema.pre('save', async function (next) {
        if (!this.isModified('password')) {
          return next();
        }
        this.password = await bcrypt.hash(this.password, 10);
        next();
      });
      return schema;
    },
  },
];

@Module({
  imports: [MongooseModule.forFeatureAsync(featureOption)],
  providers: [UsersService],
  controllers: [UsersController],
  exports: [UsersService],
})
export class UsersModule {}
