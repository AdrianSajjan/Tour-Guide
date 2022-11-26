-- DropForeignKey
ALTER TABLE "Tour" DROP CONSTRAINT "Tour_locationId_fkey";

-- AlterTable
ALTER TABLE "Tour" ALTER COLUMN "locationId" DROP NOT NULL;

-- AddForeignKey
ALTER TABLE "Tour" ADD CONSTRAINT "Tour_locationId_fkey" FOREIGN KEY ("locationId") REFERENCES "Location"("id") ON DELETE SET NULL ON UPDATE CASCADE;
