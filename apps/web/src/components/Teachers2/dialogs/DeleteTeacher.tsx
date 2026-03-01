import { useSelectedRow } from '../context/selected-row-provider';
import {
  AlertDialog,
  AlertDialogCancel,
  AlertDialogContent,
  AlertDialogDescription,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogTitle,
} from '@/components/ui/alert-dialog';
import { useMutation, useQueryClient } from '@tanstack/react-query';
import { toast } from 'sonner';
import { Button } from '@/components/ui/button';
import teacherService from '@/Api/service/teacherService';

const DeleteTeacher = () => {
  const { handleCancel, openDialog, currentRow } = useSelectedRow();
  if (!currentRow) throw new Error('No row selected');

  const queryClient = useQueryClient();

  const { mutateAsync } = useMutation({
    mutationKey: ['teachers', 'delete'],
    mutationFn: teacherService.delete,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['teachers'], exact: false });
      toast.success('Teacher deleted successfully');
      handleCancel();
    },
  });

  const deleteTeacher = async () => {
    try {
      await mutateAsync(currentRow.id);
    } catch {
      toast.error('Failed to delete teacher');
      handleCancel();
    }
  };
  const dialogOpen = openDialog === 'delete';
  return (
    <>
      <AlertDialog open={dialogOpen} onOpenChange={handleCancel}>
        <AlertDialogContent>
          <AlertDialogHeader>
            <AlertDialogTitle>Are you absolutely sure?</AlertDialogTitle>
            <AlertDialogDescription>
              This action cannot be undone. This will permanently delete the teacher &quot;{currentRow?.firstName}{' '}
              {currentRow?.lastName}
              &quot; and remove its data from our servers.
            </AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel onClick={handleCancel}>Cancel</AlertDialogCancel>
            <Button onClick={deleteTeacher} className=" bg-red-600 hover:bg-red-500">
              Delete
            </Button>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </>
  );
};

export default DeleteTeacher;
