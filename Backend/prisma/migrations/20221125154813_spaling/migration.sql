/*
  Warnings:

  - You are about to drop the column `ratingAverage` on the `Tour` table. All the data in the column will be lost.
  - You are about to drop the column `ratingQuantity` on the `Tour` table. All the data in the column will be lost.

*/
-- AlterTable
ALTER TABLE "Tour" DROP COLUMN "ratingAverage",
DROP COLUMN "ratingQuantity",
ADD COLUMN     "ratingsAverage" DECIMAL(65,30) NOT NULL DEFAULT 4.5,
ADD COLUMN     "ratingsQuantity" INTEGER NOT NULL DEFAULT 0;
