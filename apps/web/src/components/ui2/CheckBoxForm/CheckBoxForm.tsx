import { Checkbox } from '@/components/ui/checkbox';
import { Field, FieldContent, FieldDescription, FieldLabel, FieldTitle } from '@/components/ui/field';
import { type ControllerFieldState, type ControllerRenderProps, type FieldValues, type Path } from 'react-hook-form';

const CheckBoxForm = <T extends FieldValues>({
  field,
  fieldState,
  title,
  description,
}: {
  field: ControllerRenderProps<T, Path<T>>;
  fieldState: ControllerFieldState;
  title: string;
  description: string;
}) => {
  return (
    <FieldLabel>
      <Field orientation="horizontal" data-invalid={fieldState.invalid}>
        <Checkbox checked={field.value} onCheckedChange={field.onChange} />
        <FieldContent>
          <FieldTitle>{title}</FieldTitle>
          <FieldDescription>{description}</FieldDescription>
        </FieldContent>
      </Field>
    </FieldLabel>
  );
};

export default CheckBoxForm;
