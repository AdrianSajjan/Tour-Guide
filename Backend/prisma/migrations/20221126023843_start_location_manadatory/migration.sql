/*
  Warnings:

  - Made the column `locationId` on table `Tour` required. This step will fail if there are existing NULL values in that column.

*/
-- DropForeignKey
ALTER TABLE "Tour" DROP CONSTRAINT "Tour_locationId_fkey";

-- AlterTable
ALTER TABLE "Tour" ALTER COLUMN "locationId" SET NOT NULL;

-- AddForeignKey
ALTER TABLE "Tour" ADD CONSTRAINT "Tour_locationId_fkey" FOREIGN KEY ("locationId") REFERENCES "Location"("id") ON DELETE RESTRICT ON UPDATE CASCADE;
