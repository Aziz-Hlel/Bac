import { MajorEnums, OptionalSubjectEnums, TermEnums } from '@/enums/rest';
import z from 'zod';

export const SchoolMajorsSchema = z.object({
  classNumber: z
    .number({
      error: 'Class number must be a number',
    })
    .min(1, 'Class number must be at least 1')
    .max(50, 'Class number must be at most 50'),

  majorName: z.enum(Object.values(MajorEnums)).nonoptional(),
  term: z.enum(TermEnums).default(TermEnums.PRINCIPAL).nonoptional(),
});

export const schoolOptionalSubjectsSchema = z.object({
  optionalSubject: z.enum(Object.values(OptionalSubjectEnums)).nonoptional(),
  term: z.enum(TermEnums).default(TermEnums.PRINCIPAL).nonoptional(),
  classNumber: z
    .number({
      error: 'Class number must be a number',
    })
    .min(1, 'Class number must be at least 1')
    .max(50, 'Class number must be at most 50'),
});

export const schoolExamsSchema = z.object({
  schoolMajors: z.array(SchoolMajorsSchema),
  schoolOptionalSubjects: z.array(schoolOptionalSubjectsSchema),
});

export type SchoolMajors = z.infer<typeof SchoolMajorsSchema>;
export type SchoolOptionalSubjects = z.infer<typeof schoolOptionalSubjectsSchema>;
export type SchoolExams = z.infer<typeof schoolExamsSchema>;
