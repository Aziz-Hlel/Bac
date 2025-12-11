import TeachersTable from '@/components/teachers/TeachersTable';
import BreadcrumbHeader from './Header';

const TeachersMainPage = () => {
  return (
    <div>
      <BreadcrumbHeader breadcrumbs={[{ title: 'Teachers', href: '/teachers' }]} />
      <div className=" flex w-10/12">
        <TeachersTable />
      </div>
    </div>
  );
};

export default TeachersMainPage;
