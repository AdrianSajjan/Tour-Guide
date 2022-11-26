import { Injectable } from '@nestjs/common';
import { PrismaService } from '../prisma/prisma.service';
import TourDto from './Dao/tour.dto';
import Location from './interfaces/location.interface';
@Injectable()
export class TourService {
  constructor(private readonly prisma: PrismaService) {}

  async getAllTours() {
    return await this.prisma.tour.findMany({
      include: {
        TourLocations: { include: { location: true } },
        startLocation: true,
        startDates: true,
      },
    });
  }

  async createTour(tourDto: TourDto) {
    const startLocation = tourDto.startLocation;
    const locations = tourDto.locations;
    const starDates = tourDto.startDates;
    tourDto.startDates = undefined;
    tourDto.locations = undefined;
    tourDto.startLocation = undefined;
    const startLocationId = await this.addNewLocation(startLocation);

    const newTour = await this.prisma.tour.create({
      data: { ...tourDto, locationId: startLocationId as never },
    });
    locations.forEach(async (loc) => {
      await this.addNewTourLocation(newTour.id, loc);
    });
    await this.addStartDates(newTour.id, starDates);
    return newTour;
  }
  async addNewLocation(location: Location): Promise<string> {
    console.log(location);
    const newLocation = await this.prisma.location.create({
      data: location,
    });
    return newLocation.id;
  }
  async addNewTourLocation(tourId: string, location: Location) {
    const day = location.day;
    location.day = undefined;
    const locationId = await this.addNewLocation(location);
    await this.prisma.tourLocations.create({
      data: {
        tourId,
        locationId,
        Day: day,
      },
    });
  }
  async addStartDates(tourId: string, starDates: Date[]) {
    starDates.forEach(async (date) => {
      await this.prisma.tourDates.create({
        data: {
          time: date,
          tourId: tourId,
        },
      });
    });
  }
}
