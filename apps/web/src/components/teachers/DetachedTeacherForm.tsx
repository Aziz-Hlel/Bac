import type { CreateTeacherRequest } from '@/types/teacher/Teacher';
import { type FC } from 'react';
import { Controller, type UseFormReturn } from 'react-hook-form';
import { Field, FieldError, FieldGroup, FieldLabel } from '../ui/field';
import { Input } from '../ui/input';

interface DetachedTeacherFormProps {
  form: UseFormReturn<CreateTeacherRequest>;
}

const DetachedTeacherForm: FC<DetachedTeacherFormProps> = ({ form }) => {
  const formId = 'create-teacher-form';
  return (
    <div>
      <div>DetachedTeacherForm</div>
      <FieldGroup>
        <Controller
          name="firstName"
          control={form.control}
          render={({ field, fieldState }) => (
            <Field data-invalid={fieldState.invalid}>
              <FieldLabel htmlFor={`${formId}-${field.name}`}>First Name</FieldLabel>
              <Input
                {...field}
                id={`${formId}-${field.name}`}
                aria-invalid={fieldState.invalid}
                placeholder="First Name"
              />
              {fieldState.invalid && <FieldError errors={[fieldState.error]} />}
            </Field>
          )}
        />

        <Controller
          name="firstName"
          control={form.control}
          render={({ field, fieldState }) => (
            <Field data-invalid={fieldState.invalid}>
              <FieldLabel htmlFor={`${formId}-${field.name}`}>First Name</FieldLabel>
              <Input
                {...field}
                id={`${formId}-${field.name}`}
                aria-invalid={fieldState.invalid}
                placeholder="First Name"
              />
              {fieldState.invalid && <FieldError errors={[fieldState.error]} />}
            </Field>
          )}
        />
      </FieldGroup>
    </div>
  );
};

export default DetachedTeacherForm;
