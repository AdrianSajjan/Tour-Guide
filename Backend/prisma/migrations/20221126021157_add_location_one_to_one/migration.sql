/*
  Warnings:

  - A unique constraint covering the columns `[locationId]` on the table `Tour` will be added. If there are existing duplicate values, this will fail.

*/
-- CreateIndex
CREATE UNIQUE INDEX "Tour_locationId_key" ON "Tour"("locationId");
