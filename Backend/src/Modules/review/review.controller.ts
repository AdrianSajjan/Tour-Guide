import { Controller, Get, Param, Post, UseGuards } from '@nestjs/common';
import { ApiTags } from '@nestjs/swagger';
import { JwtAccessTokenGuard } from '../auth/Gaurds/jwtAccesssToken.auth.gaurd';
import { ReviewService } from './review.service';

@Controller()
@UseGuards(JwtAccessTokenGuard)
@ApiTags('Review')
export class ReviewController {
  constructor(private readonly reviewService: ReviewService) {}

  @Get()
  async getAllReview(@Param() param: { tourId: string }) {
    return await this.reviewService.getAllReview(param.tourId);
  }
}
