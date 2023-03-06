import { Injectable } from '@nestjs/common';
import { InjectModel } from '@nestjs/mongoose';
import { Model } from 'mongoose';
import { teacher, teacherDocument } from 'src/schemas/teacher.schema';

@Injectable()
export class teacherRepo {
    constructor(
        @InjectModel(teacher.name)
        private readonly teacherModel: Model<teacherDocument>) {}

    async create(data): Promise<teacher> {
        return new this.teacherModel(data).save();
    }

    async findAll(): Promise<teacher[]> {
        return this.teacherModel.find({})
            .exec();
    }

    async update(teacherId, data): Promise<teacher> {
        const filter = { _id: teacherId };
        return this.teacherModel.findOneAndUpdate(filter, data);
    }

    async delete(teacherId): Promise<teacher> {
        const filter = { _id: teacherId };
        return this.teacherModel.findByIdAndDelete(teacherId);
    }
}