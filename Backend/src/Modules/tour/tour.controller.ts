import { Body, Controller, Get, Post, UseGuards } from '@nestjs/common';
import { ApiTags } from '@nestjs/swagger';
import { JwtAccessTokenGuard } from '../auth/Gaurds/jwtAccesssToken.auth.gaurd';
import TourDto from './Dao/tour.dto';
import { TourService } from './tour.service';

@Controller()
@ApiTags('Tour')
@UseGuards(JwtAccessTokenGuard)
export class TourController {
  constructor(private tourService: TourService) {}

  @Get()
  async getAllTours() {
    return await this.tourService.getAllTours();
  }

  @Post()
  async createTour(@Body() tourDto: TourDto) {
    tourDto;
    return await this.tourService.createTour(tourDto);
  }
}
