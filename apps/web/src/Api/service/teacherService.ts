import { apiService } from '../apiService';
import apiRoutes from '../routes/routes';
import type { TeacherRowResponse } from '@/types/teacher/Teacher';
import type { Page } from '@/types/page/Page';

const teacherService = {
  getTeachers: async (searchParams: { [k: string]: string | number }) =>
    apiService.getThrowable<Page<TeacherRowResponse>>(apiRoutes.teachers.getPage(), { params: searchParams }),
};
export default teacherService;
