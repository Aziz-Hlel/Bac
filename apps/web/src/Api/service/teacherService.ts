import { apiService } from '../apiService';
import apiRoutes from '../routes/routes';
import type { CreateTeacherRequest, TeacherRowResponse, UpdateTeacherRequest } from '@/types/teacher/Teacher';
import type { Page } from '@/types/page/Page';

const teacherService = {
  getPage: async (searchParams: { [k: string]: string | number }) =>
    apiService.getThrowable<Page<TeacherRowResponse>>(apiRoutes.teachers.getPage(), { params: searchParams }),
  create: async (teacher: CreateTeacherRequest) =>
    apiService.postThrowable<TeacherRowResponse>(apiRoutes.teachers.add(), teacher),
  update: async (teacher: UpdateTeacherRequest) =>
    apiService.putThrowable<TeacherRowResponse>(apiRoutes.teachers.update(), teacher),
};
export default teacherService;
