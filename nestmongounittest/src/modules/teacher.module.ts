import { Module } from '@nestjs/common';
import { MongooseModule } from '@nestjs/mongoose';
import { teacherController } from '../controllers/teacher.controller';
import { teacherService } from '../services/teacher.service';
import { teacherRepo } from '../repository/teacher.repo';
import { teacher, teacherSchema } from '../schemas/teacher.schema';

@Module({
    imports: [
        MongooseModule.forFeature([{ name: teacher.name, schema: teacherSchema }])
    ],
    controllers: [teacherController],
    providers: [teacherService, teacherRepo],
    exports: [teacherService, teacherRepo]
  })
  export class teacherModule { }