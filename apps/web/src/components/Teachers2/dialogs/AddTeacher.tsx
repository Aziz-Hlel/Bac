import { useSelectedRow } from '../context/selected-row-provider';
import { useMutation, useQueryClient } from '@tanstack/react-query';
import { Controller, useForm, type SubmitHandler } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
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
import { Spinner } from '@/components/ui/spinner';
import { Field, FieldError, FieldGroup, FieldLabel } from '@/components/ui/field';
import { Input } from '@/components/ui/input';
import { toast } from 'sonner';
import teacherService from '@/Api/service/teacherService';
import { createTeacherSchema, type CreateTeacherRequest } from '@/types/teacher/Teacher';
import { PrefixEnumMapping, SubjectEnumsMapping } from '@/enums/EnumMapping';
import SelectForm from '@/components/ui2/SelectForm/SelectForm';
import CheckBoxForm from '@/components/ui2/CheckBoxForm/CheckBoxForm';
import { useEffect } from 'react';

const AddTeacher = () => {
  const { handleCancel, openDialog } = useSelectedRow();
  const queryClient = useQueryClient();

  const { mutateAsync, isPending } = useMutation({
    mutationKey: ['teachers', 'create'],
    mutationFn: teacherService.create,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['teachers'], exact: false });
      form.reset();
      handleCancel();
    },
  });

  const defaultValues: CreateTeacherRequest = {
    firstName: '',
    lastName: '',
    isTeacher: true,
    prefix: null,
    publicId: '',
    subject: null,
  };

  const form = useForm<CreateTeacherRequest>({
    resolver: zodResolver(createTeacherSchema),
    defaultValues: defaultValues,
  });

  const onOpenChange = (open: boolean) => {
    if (!open) {
      form.reset();
      handleCancel();
    }
  };

  const onSubmit: SubmitHandler<CreateTeacherRequest> = async (data) => {
    try {
      await mutateAsync(data);
      toast.success('Teacher created successfully');
    } catch (error) {
      console.log(error);
      toast.error('Failed to create teacher');
    }
  };

  const dialogIsOpen = openDialog === 'add';

  console.log('form :', form.getValues());

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
            <DialogTitle>Create Teacher</DialogTitle>
            <DialogDescription>Fill the form below to create a new teacher.</DialogDescription>
          </DialogHeader>
          <div
            className=" 
              flex-1 min-h-0 overflow-y-auto pr-2  overscroll-contain scrollbar-thin scrollbar-thumb-neutral-300 scrollbar-track-transparent hover:scrollbar-thumb-neutral-400"
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

export default AddTeacher;
