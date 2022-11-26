-- DropForeignKey
ALTER TABLE "TourLocations" DROP CONSTRAINT "TourLocations_locationId_fkey";

-- DropForeignKey
ALTER TABLE "TourLocations" DROP CONSTRAINT "TourLocations_tourId_fkey";

-- AddForeignKey
ALTER TABLE "TourLocations" ADD CONSTRAINT "TourLocations_tourId_fkey" FOREIGN KEY ("tourId") REFERENCES "Tour"("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "TourLocations" ADD CONSTRAINT "TourLocations_locationId_fkey" FOREIGN KEY ("locationId") REFERENCES "Location"("id") ON DELETE CASCADE ON UPDATE CASCADE;
