import { MiddlewareConsumer, Module, NestModule } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { ConfigModule } from '@nestjs/config';
import { UsersModule } from '../users/users.module';
import { AuthModule } from '../auth/auth.module';
import { TourModule } from '../tour/tour.module';
import { RouterModule } from '@nestjs/core';
import { ReviewModule } from '../review/review.module';
import { AppLoggerMiddleware } from 'src/middleware/logger.middleweare';

@Module({
  imports: [
    ConfigModule.forRoot(),
    AuthModule,
    UsersModule,
    TourModule,
    ReviewModule,
    RouterModule.register([
      {
        path: 'auth',
        module: AuthModule,
      },
      {
        path: 'tour',
        module: TourModule,
        children: [
          {
            path: ':tourId/review',
            module: ReviewModule,
          },
        ],
      },
    ]),
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule implements NestModule {
  configure(consumer: MiddlewareConsumer): void {
    consumer.apply(AppLoggerMiddleware).forRoutes('*');
  }
}
