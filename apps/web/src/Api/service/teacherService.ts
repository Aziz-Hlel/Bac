import { apiService } from '../apiService';
import apiRoutes from '../routes/routes';
import type { CreateTeacherRequest, TeacherRowResponse, UpdateTeacherRequest } from '@/types/teacher/Teacher';
import type { Page } from '@/types/page/Page';

const teacherService = {
  getPage: async (searchParams: { [k: string]: string | number }) =>
    apiService.getThrowable<Page<TeacherRowResponse>>(apiRoutes.teachers.getPage(), { params: searchParams }),
  create: async (teacher: CreateTeacherRequest) =>
    apiService.postThrowable<TeacherRowResponse>(apiRoutes.teachers.add(), teacher),
  update: async (data: { id: string; teacher: UpdateTeacherRequest }) =>
    apiService.putThrowable<TeacherRowResponse>(apiRoutes.teachers.update(data.id), data.teacher),
  delete: async (id: string) => apiService.deleteThrowable(apiRoutes.teachers.delete(id)),
};
export default teacherService;
