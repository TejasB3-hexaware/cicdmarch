import { Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import { Document } from 'mongoose';

export type teacherDocument = teacher & Document;

@Schema()
export class teacher {
   
   @Prop()
   name: string; 
   
}

export const teacherSchema = SchemaFactory.createForClass(teacher);