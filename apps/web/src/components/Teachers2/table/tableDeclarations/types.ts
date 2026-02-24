import type { TeacherRowResponse } from '@/types/teacher/Teacher';
import z from 'zod';

export type TeacherTableRowType = TeacherRowResponse;

export type RootKeys = keyof TeacherTableRowType;
export type TableRowKeys = RootKeys;

export const TeacherColumnFiltersKeys: Set<TableRowKeys> = new Set(['isTeacher', 'prefix'] as const);

export const TeacherSortableColumnKeys: TableRowKeys[] = [
  'prefix',
  'firstName',
  'lastName',
  'isTeacher',
  'publicId',
  'subject',
] as const;

export const TeacherPageQuerySortFields: RootKeys[] = ['firstName', 'lastName', 'prefix', 'subject'];

export const TeacherQueryParamsSchema = z.object({
  page: z.coerce.number().int().positive().catch(1),
  size: z.coerce.number().int().min(5).max(50).catch(10),
  sort: z.enum(TeacherPageQuerySortFields).catch('firstName'),
  order: z.enum(['asc', 'desc']).catch('desc'),
  search: z.string().trim().catch(''),
});
export type TableQueryParams = z.infer<typeof TeacherQueryParamsSchema>;
export type TeacherRequiredTableQueryParams = TableQueryParams;

export const TeacherDefaultQuery: TeacherRequiredTableQueryParams = {
  page: 1,
  size: 10,
  sort: 'firstName',
  order: 'desc',
  search: '',
};

export type TeacherPageQuery = z.infer<typeof TeacherQueryParamsSchema>;
