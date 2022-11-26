-- CreateEnum
CREATE TYPE "Role" AS ENUM ('user', 'admin');

-- CreateEnum
CREATE TYPE "difficulty" AS ENUM ('easy', 'medium', 'difficulty');

-- DropEnum
DROP TYPE "role";

-- CreateTable
CREATE TABLE "Images" (
    "imageId" TEXT NOT NULL,
    "imageUrl" TEXT NOT NULL,
    "tourName" TEXT,
    "tourId" TEXT,

    CONSTRAINT "Images_pkey" PRIMARY KEY ("imageId")
);

-- CreateTable
CREATE TABLE "Tour" (
    "id" TEXT NOT NULL,
    "name" TEXT NOT NULL,
    "duration" INTEGER NOT NULL,
    "maxGroupSize" INTEGER NOT NULL,
    "difficulty" TEXT NOT NULL,
    "ratingAverage" DECIMAL(65,30) NOT NULL DEFAULT 4.5,
    "ratingQuantity" INTEGER NOT NULL DEFAULT 0,
    "price" INTEGER NOT NULL,
    "priceDiscount" INTEGER,
    "summery" TEXT NOT NULL,
    "description" TEXT NOT NULL,
    "coverImage" TEXT,
    "imagesImageId" TEXT NOT NULL,

    CONSTRAINT "Tour_pkey" PRIMARY KEY ("id")
);

-- CreateIndex
CREATE UNIQUE INDEX "Tour_name_key" ON "Tour"("name");

-- AddForeignKey
ALTER TABLE "Images" ADD CONSTRAINT "Images_tourId_fkey" FOREIGN KEY ("tourId") REFERENCES "Tour"("id") ON DELETE SET NULL ON UPDATE CASCADE;
