import { Card, CardAction, CardContent, CardDescription, CardHeader, CardTitle } from '../ui/card';
import BreadcrumbHeader from '@/pages/Header';
import { Button } from '../ui/button';
import { useSelectedRow } from './context/selected-row-provider';
import DialogContainer from './dialogs/DialogContainer';
import TeacherTable from './TeacherTable';

const TeacherIndex = () => {
  const { handleDialogChange } = useSelectedRow();
  return (
    <div>
      <BreadcrumbHeader breadcrumbs={[{ title: 'Teachers', href: '/teachers' }]} />
      <div className=" w-full mx-auto">
        <Card>
          <CardHeader>
            <CardTitle>Teachers List</CardTitle>
            <CardDescription>Manage your teachers and their details here.</CardDescription>
            <CardAction>
              <Button onClick={() => handleDialogChange('add')}>Add New Teacher</Button>
            </CardAction>
          </CardHeader>
          <CardContent>
            <TeacherTable />
            <DialogContainer />
          </CardContent>
        </Card>
      </div>
    </div>
  );
};

export default TeacherIndex;
