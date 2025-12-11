import { PrefixEnum, SubjectEnums } from '@/enums/rest';
import { z } from 'zod';

export const createTeacherSchema = z.object({
  publicId: z.string().max(30).optional().nullable(),
  prefix: z.enum(Object.keys(PrefixEnum)).optional().nullable(),
  firstName: z.string({ error: 'First name is required' }).min(1, 'First name is required').max(100).trim(),
  lastName: z.string({ error: 'Last name is required' }).min(1, 'Last name is required').max(100).trim(),
  subject: z.enum(Object.keys(SubjectEnums)).optional().nullable(),
  isTeacher: z.boolean(),
});

// Schema for a full teacher entity (includes all fields)
export const teacherSchema = z.object({
  id: z.uuid(),
  publicId: z.string().max(30).nullable(),
  prefix: z.enum(Object.keys(PrefixEnum)).nullable(),
  firstName: z.string().max(100),
  lastName: z.string().max(100),
  subject: z.enum(Object.keys(SubjectEnums)).nullable(),
  isTeacher: z.boolean(),
  schoolId: z.uuid(),
  userId: z.string(),
});

// TypeScript types
export type CreateTeacher = z.infer<typeof createTeacherSchema>;
export type TeacherRowResponse = z.infer<typeof teacherSchema>;
export type TeacherResponse = z.infer<typeof teacherSchema>;
