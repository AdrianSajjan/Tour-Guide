/*
  Warnings:

  - You are about to drop the column `locations` on the `Tour` table. All the data in the column will be lost.
  - You are about to drop the column `startLocation` on the `Tour` table. All the data in the column will be lost.
  - Added the required column `locationId` to the `Tour` table without a default value. This is not possible if the table is not empty.

*/
-- AlterTable
ALTER TABLE "Tour" DROP COLUMN "locations",
DROP COLUMN "startLocation",
ADD COLUMN     "locationId" TEXT NOT NULL;

-- CreateTable
CREATE TABLE "Location" (
    "id" TEXT NOT NULL,
    "description" TEXT NOT NULL,
    "longitude" INTEGER NOT NULL,
    "latitude" INTEGER NOT NULL,

    CONSTRAINT "Location_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "TourLocations" (
    "tourId" TEXT NOT NULL,
    "locationId" TEXT NOT NULL,

    CONSTRAINT "TourLocations_pkey" PRIMARY KEY ("tourId","locationId")
);

-- AddForeignKey
ALTER TABLE "TourLocations" ADD CONSTRAINT "TourLocations_tourId_fkey" FOREIGN KEY ("tourId") REFERENCES "Tour"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "TourLocations" ADD CONSTRAINT "TourLocations_locationId_fkey" FOREIGN KEY ("locationId") REFERENCES "Location"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Tour" ADD CONSTRAINT "Tour_locationId_fkey" FOREIGN KEY ("locationId") REFERENCES "Location"("id") ON DELETE RESTRICT ON UPDATE CASCADE;
