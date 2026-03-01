import { useSelectedRow } from '../context/selected-row-provider';
import { useMutation, useQueryClient } from '@tanstack/react-query';
import { Controller, useForm, type SubmitHandler } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import { toast } from 'sonner';
import {
  Dialog,
  DialogClose,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import { Button } from '@/components/ui/button';
import { Field, FieldError, FieldGroup, FieldLabel } from '@/components/ui/field';
import { Input } from '@/components/ui/input';
import { Spinner } from '@/components/ui/spinner';
import SelectForm from '@/components/ui2/SelectForm/SelectForm';
import CheckBoxForm from '@/components/ui2/CheckBoxForm/CheckBoxForm';
import { PrefixEnumMapping, SubjectEnumsMapping } from '@/enums/EnumMapping';
import teacherService from '@/Api/service/teacherService';
import { updateTeacherSchema, type UpdateTeacherRequest } from '@/types/teacher/Teacher';
import { useEffect } from 'react';

const EditTeacher = () => {
  const { handleCancel, currentRow, openDialog } = useSelectedRow();
  const queryClient = useQueryClient();

  if (!currentRow) throw new Error('No row selected');
  console.log(currentRow);
  const { mutateAsync, isPending } = useMutation({
    mutationKey: ['teachers', 'update'],
    mutationFn: teacherService.update,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['teachers'], exact: false });
      form.reset();
      handleCancel();
    },
  });

  const defaultValues: UpdateTeacherRequest = {
    firstName: currentRow.firstName,
    lastName: currentRow.lastName,
    isTeacher: currentRow.isTeacher,
    prefix: currentRow.prefix,
    publicId: currentRow.publicId,
    subject: currentRow.subject,
  };

  const form = useForm<UpdateTeacherRequest>({
    resolver: zodResolver(updateTeacherSchema),
    defaultValues: defaultValues,
  });

  const onOpenChange = (open: boolean) => {
    if (!open) {
      form.reset();
      handleCancel();
    }
  };

  const onSubmit: SubmitHandler<UpdateTeacherRequest> = async (data) => {
    try {
      await mutateAsync({ id: currentRow.id, teacher: data });
      toast.success('Teacher updated successfully');
    } catch (error) {
      console.log(error);
      // if (error instanceof ApiError && error.status === 409) {
      //   form.setError('title', { message: 'Title already exists' });
      //   return;
      // }
      toast.error('Failed to create entertainment');
    }
  };

  const dialogIsOpen = openDialog === 'edit';
  console.log(form.formState.errors);

  const isTeacher = form.watch('isTeacher');

  useEffect(() => {
    if (isTeacher === false) {
      form.setValue('subject', null);
    }
  }, [isTeacher, form]);

  return (
    <Dialog onOpenChange={onOpenChange} open={dialogIsOpen}>
      <DialogContent className="sm:max-w-106.25 h-[calc(100dvh-4rem)] flex flex-col overflow-hidden  ">
        <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-6 flex flex-col h-full">
          <DialogHeader>
            <DialogTitle>Update Teacher</DialogTitle>
            <DialogDescription>Fill the form below to update the teacher.</DialogDescription>
          </DialogHeader>
          <div
            className=" flex-1 min-h-0 overflow-y-auto pr-2
              overscroll-contain scrollbar-thin scrollbar-thumb-neutral-300 
              scrollbar-track-transparent hover:scrollbar-thumb-neutral-400"
          >
            <FieldGroup>
              <Controller
                name="publicId"
                control={form.control}
                render={({ field, fieldState }) => (
                  <Field data-invalid={fieldState.invalid}>
                    <FieldLabel htmlFor={`publicId-input`}>Public ID</FieldLabel>
                    <Input
                      {...field}
                      value={field.value ?? ''}
                      id={`publicId-input`}
                      aria-invalid={fieldState.invalid}
                      placeholder="Public ID"
                    />
                    {fieldState.invalid && <FieldError errors={[fieldState.error]} />}
                  </Field>
                )}
              />
              {/* <Controller
              name="isTeacher"
              control={form.control}
              render={({ field, fieldState }) => (
                <Field data-invalid={fieldState.invalid}>
                  <FieldLabel htmlFor={`isTeacher-input`}>Is Teacher</FieldLabel>
                  <Checkbox checked={field.value} onCheckedChange={field.onChange} />
                </Field>
              )}
            /> */}

              <Controller
                name="prefix"
                control={form.control}
                render={({ field, fieldState }) => (
                  <Field data-invalid={fieldState.invalid} className="flex">
                    <FieldLabel htmlFor={`prefix-input`}>Prefix</FieldLabel>
                    <SelectForm field={field} options={PrefixEnumMapping} placeholder="Select prefix" label="Prefix" />
                  </Field>
                )}
              />

              <Controller
                name="firstName"
                control={form.control}
                render={({ field, fieldState }) => (
                  <Field data-invalid={fieldState.invalid}>
                    <FieldLabel htmlFor={`firstName-input`}>First Name</FieldLabel>
                    <Input
                      {...field}
                      id={`firstName-input`}
                      aria-invalid={fieldState.invalid}
                      placeholder="First Name"
                    />
                    {fieldState.invalid && <FieldError errors={[fieldState.error]} />}
                  </Field>
                )}
              />

              <Controller
                name="lastName"
                control={form.control}
                render={({ field, fieldState }) => (
                  <Field data-invalid={fieldState.invalid}>
                    <FieldLabel htmlFor={`lastName-input`}>Last Name</FieldLabel>
                    <Input
                      {...field}
                      id={`firstName-input`}
                      aria-invalid={fieldState.invalid}
                      placeholder="First Name"
                    />
                    {fieldState.invalid && <FieldError errors={[fieldState.error]} />}
                  </Field>
                )}
              />

              <Controller
                name="isTeacher"
                control={form.control}
                render={({ field, fieldState }) => (
                  <CheckBoxForm
                    field={field}
                    fieldState={fieldState}
                    title="Is Teacher"
                    description="Check this box if the person is a teacher"
                  />
                )}
              />

              <Controller
                name="subject"
                control={form.control}
                render={({ field, fieldState }) => (
                  <Field data-invalid={fieldState.invalid} className="flex">
                    <FieldLabel htmlFor={`subject-input`}>Subject</FieldLabel>
                    <SelectForm
                      field={field}
                      options={SubjectEnumsMapping}
                      placeholder="Select subject"
                      label="Subject"
                      props={{
                        disabled: isTeacher === false,
                      }}
                    />
                  </Field>
                )}
              />
            </FieldGroup>
          </div>
          <DialogFooter>
            <DialogClose asChild>
              <Button variant="outline" onClick={handleCancel}>
                Cancel
              </Button>
            </DialogClose>
            <Button type="submit" className=" w-28" disabled={isPending}>
              {isPending ? <Spinner /> : <span>Save changes</span>}
            </Button>
          </DialogFooter>
        </form>
      </DialogContent>
    </Dialog>
  );
};

export default EditTeacher;
