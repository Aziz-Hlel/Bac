import type { SchoolExams } from '@/types/onboard/schoolExams';
import { apiService } from '../apiService';
import apiRoutes from '../routes/routes';
import type { SimpleApiResponse } from '@/types/api/SimpleApiResponse';

export const schoolExamsService = {
  createSchoolExam: ({ schoolId, payload }: { schoolId: string; payload: SchoolExams }) => {
    return apiService.postThrowable<SimpleApiResponse>(apiRoutes.schoolExams.create(schoolId), payload);
  },
};
