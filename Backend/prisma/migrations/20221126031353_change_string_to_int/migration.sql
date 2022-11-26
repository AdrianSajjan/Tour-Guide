/*
  Warnings:

  - The `Day` column on the `TourLocations` table would be dropped and recreated. This will lead to data loss if there is data in the column.

*/
-- AlterTable
ALTER TABLE "TourLocations" DROP COLUMN "Day",
ADD COLUMN     "Day" INTEGER;
