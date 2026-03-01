import { useSelectedRow } from '../context/selected-row-provider';
import AddTeacher from './AddTeacher';
import DeleteTeacher from './DeleteTeacher';
import EditTeacher from './EditTeacher';

const DialogContainer = () => {
  const { openDialog } = useSelectedRow();
  if (openDialog === 'add') return <AddTeacher />;
  if (openDialog === 'delete') return <DeleteTeacher />;
  if (openDialog === 'edit') return <EditTeacher />;
  return null;
};

export default DialogContainer;
