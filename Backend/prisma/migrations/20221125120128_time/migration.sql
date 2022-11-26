/*
  Warnings:

  - You are about to drop the column `coverImage` on the `Tour` table. All the data in the column will be lost.
  - You are about to drop the column `startDates` on the `Tour` table. All the data in the column will be lost.

*/
-- AlterTable
ALTER TABLE "Tour" DROP COLUMN "coverImage",
DROP COLUMN "startDates",
ADD COLUMN     "imageCover" TEXT;

-- CreateTable
CREATE TABLE "tourDates" (
    "id" TEXT NOT NULL,
    "time" TIMESTAMP(3) NOT NULL,
    "tourId" TEXT NOT NULL,

    CONSTRAINT "tourDates_pkey" PRIMARY KEY ("id")
);

-- AddForeignKey
ALTER TABLE "tourDates" ADD CONSTRAINT "tourDates_tourId_fkey" FOREIGN KEY ("tourId") REFERENCES "Tour"("id") ON DELETE RESTRICT ON UPDATE CASCADE;
