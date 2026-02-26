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

export const updateTeacherSchema = z.object({
  publicId: z.string().max(30).optional().nullable(),
  prefix: z.enum(Object.keys(PrefixEnum)).optional().nullable(),
  firstName: z.string({ error: 'First name is required' }).min(1, 'First name is required').max(100).trim(),
  lastName: z.string({ error: 'Last name is required' }).min(1, 'Last name is required').max(100).trim(),
  subject: z.enum(Object.keys(SubjectEnums)).optional().nullable(),
  isTeacher: z.boolean(),
});

// Schema for a full teacher entity (includes all fields)
export const teacherResponseSchema = z.object({
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
export type CreateTeacherRequest = z.infer<typeof createTeacherSchema>;
export type UpdateTeacherRequest = z.infer<typeof updateTeacherSchema>;
export type TeacherRowResponse = z.infer<typeof teacherResponseSchema>;
export type TeacherResponse = z.infer<typeof teacherResponseSchema>;
