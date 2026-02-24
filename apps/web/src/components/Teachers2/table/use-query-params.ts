import { useSearchParams } from 'react-router-dom';
import { useMemo } from 'react';
import { TeacherQueryParamsSchema } from './tableDeclarations/types';

const useQueryParams = () => {
  const [searchParams] = useSearchParams();
  const params = Object.fromEntries(searchParams.entries());
  const parsedQueryParams = useMemo(() => TeacherQueryParamsSchema.parse(params), [params]);

  return {
    queryParams: parsedQueryParams,
  };
};

export default useQueryParams;
