import { Module } from '@nestjs/common';
import { TourService } from './tour.service';
import { TourController } from './tour.controller';
import { PrismaModule } from '../prisma/prisma.module';

@Module({
  providers: [TourService],
  controllers: [TourController],
  imports: [PrismaModule],
})
export class TourModule {}
