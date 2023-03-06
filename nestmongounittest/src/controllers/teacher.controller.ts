import { Body, Controller, Delete, Get, Param, Post, Put } from '@nestjs/common';
import { teacherDto } from '../dto/teacher-dto.dto';
import { teacherService } from '../services/teacher.service';


@Controller('teacher')
export class teacherController {
    constructor(private readonly teacherService: teacherService) { }

    @Post()
    async create(@Body() teacherDto: teacherDto) {
        const res = this.teacherService.create(teacherDto);
        return res;
    }

    @Get()
    async findAll() {
        return this.teacherService.findAll();
    }

    @Put('/:id')
    update(@Param('id') id: string, @Body() teacherDto: teacherDto) {
        return this.teacherService.update(id, teacherDto);
    }

    @Delete('/:id')
    delete(@Param('id') id: string) {
        return this.teacherService.delete(id);
    }
}