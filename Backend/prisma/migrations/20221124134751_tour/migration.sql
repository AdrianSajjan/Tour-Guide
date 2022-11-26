/*
  Warnings:

  - You are about to drop the column `imagesImageId` on the `Tour` table. All the data in the column will be lost.
  - Made the column `tourName` on table `Images` required. This step will fail if there are existing NULL values in that column.
  - Made the column `tourId` on table `Images` required. This step will fail if there are existing NULL values in that column.
  - Added the required column `locations` to the `Tour` table without a default value. This is not possible if the table is not empty.
  - Added the required column `startDate` to the `Tour` table without a default value. This is not possible if the table is not empty.
  - Added the required column `startLocation` to the `Tour` table without a default value. This is not possible if the table is not empty.

*/
-- DropForeignKey
ALTER TABLE "Images" DROP CONSTRAINT "Images_tourId_fkey";

-- AlterTable
ALTER TABLE "Images" ALTER COLUMN "tourName" SET NOT NULL,
ALTER COLUMN "tourId" SET NOT NULL;

-- AlterTable
ALTER TABLE "Tour" DROP COLUMN "imagesImageId",
ADD COLUMN     "locations" JSONB NOT NULL,
ADD COLUMN     "startDate" TIMESTAMP(3) NOT NULL,
ADD COLUMN     "startLocation" JSONB NOT NULL;

-- AddForeignKey
ALTER TABLE "Images" ADD CONSTRAINT "Images_tourId_fkey" FOREIGN KEY ("tourId") REFERENCES "Tour"("id") ON DELETE RESTRICT ON UPDATE CASCADE;
