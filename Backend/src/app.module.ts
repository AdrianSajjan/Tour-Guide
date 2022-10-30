import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { ConfigModule } from '@nestjs/config';
import { MongooseModule } from '@nestjs/mongoose';
import { UsersModule } from './users/users.module';
import mongoDBConfig from './Config/mongodb.config';

@Module({
  imports: [
    ConfigModule.forRoot(),
    MongooseModule.forRootAsync(mongoDBConfig),
    UsersModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
