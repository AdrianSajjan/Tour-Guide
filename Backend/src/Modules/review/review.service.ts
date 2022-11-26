import { Injectable } from '@nestjs/common';
import { PrismaService } from '../prisma/prisma.service';

@Injectable()
export class ReviewService {
  constructor(private readonly prisma: PrismaService) {}

  async getAllReview(tourId: string) {
    return await this.prisma.reviews.findMany({ where: { tourId } });
  }
}
