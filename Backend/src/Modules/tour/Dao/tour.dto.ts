import { Prisma } from '@prisma/client';
import { IsArray, IsEnum, IsNotEmpty, IsOptional } from 'class-validator';
import locations from '../interfaces/location.interface';

class TourDto {
  id: string;

  name: string;

  @IsNotEmpty()
  duration: number;

  @IsNotEmpty()
  maxGroupSize: number;

  @IsEnum(['easy', 'medium', 'hard'], { each: true })
  difficulty: string;

  @IsOptional()
  ratingsAverage: Prisma.Decimal;

  @IsOptional()
  ratingsQuantity: number;

  @IsNotEmpty()
  price: number;

  @IsOptional()
  priceDiscount: number | null;

  summary: string;

  startDates: Date[];

  description: string;
  coverImage: string | null;
  startLocation: locations;

  @IsArray()
  locations: locations[];
}
export default TourDto;
