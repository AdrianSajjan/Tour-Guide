import { Module } from '@nestjs/common';
import { PrismaModule } from '../prisma/prisma.module';
import { ReviewController } from './review.controller';
import { ReviewService } from './review.service';

@Module({
  providers: [ReviewService],
  controllers: [ReviewController],
  imports: [PrismaModule],
})
export class ReviewModule {}
