import { Injectable } from '@nestjs/common';
import { teacherRepo } from '../repository/teacher.repo';
import { teacher } from '../schemas/teacher.schema';

@Injectable()
export class teacherService {
    constructor(
        private readonly teacherRepo: teacherRepo
    ) { }

    async findAll(): Promise<teacher[]> {
        return this.teacherRepo.findAll();
    }

    async create(data): Promise<teacher> {
        data.createddate = new Date();
        return this.teacherRepo.create(data);
    }

    async update(teacherId, data): Promise<teacher> {
        return this.teacherRepo.update(teacherId, data);
    }

    async delete(teacherId): Promise<teacher> {
        return this.teacherRepo.delete(teacherId);
    }
}