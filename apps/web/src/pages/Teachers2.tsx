import { SelectedRowProvider } from '@/components/Teachers2/context/selected-row-provider';
import TeacherIndex from '@/components/Teachers2/Teacher.index';

const Teachers2 = () => {
  return (
    <SelectedRowProvider>
      <TeacherIndex />
    </SelectedRowProvider>
  );
};

export default Teachers2;
