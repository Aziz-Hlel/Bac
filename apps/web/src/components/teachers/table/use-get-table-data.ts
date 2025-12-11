import teacherService from '@/Api/service/teacherService';
import { useQuery } from '@tanstack/react-query';
import { useSearchParams } from 'react-router-dom';

const useGetTableData = () => {
  const [searchParams] = useSearchParams();
  const params = Object.fromEntries(searchParams.entries());

  const queryParams = {
    ...params,
    page: params.page ? Number(params.page) - 1 : 0,
  };

  const { data } = useQuery({
    queryKey: ['teachers', searchParams.toString()],
    queryFn: async () => await teacherService.getTeachers(queryParams),
  });

  const tableData = data?.content ?? [];
  const pagination = data?.pagination ?? {
    size: 0,
    number: 0,
    totalElements: 0,
    totalPages: 0,
    offset: 0,
    pageSize: 0,
  };

  return { tableData, pagination };
};

export default useGetTableData;
