import {
  TeacherColumnFiltersKeys,
  TeacherDefaultQuery,
  TeacherSortableColumnKeys,
  type TeacherRequiredTableQueryParams,
  type TeacherTableRowType,
} from './types';

export type TableRowType = TeacherTableRowType;

export type TableRowKeys = keyof TableRowType;

export type RequiredTableQueryParams = TeacherRequiredTableQueryParams;

export const columnFiltersKeys = TeacherColumnFiltersKeys;

export const sortableColumnKeys = TeacherSortableColumnKeys;

export const defaultQuery = TeacherDefaultQuery;
