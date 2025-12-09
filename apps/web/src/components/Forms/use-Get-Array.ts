import { useFieldArray, type FieldValues, type UseFieldArrayProps, type UseFormReturn } from 'react-hook-form';

interface DetachedFormProps<T extends FieldValues> {
  form: UseFormReturn<T>;
  fieldName: UseFieldArrayProps<T>['name'];
}
export const useGetArray = <T extends FieldValues>({ form, fieldName }: DetachedFormProps<T>) => {
  const { fields, append, remove, swap } = useFieldArray({
    control: form.control,
    name: fieldName,
  });

  const handleDelete = (index: number) => {
    remove(index);
  };

  const handleMove = (oldIndex: number, newIndex: number) => {
    swap(oldIndex, newIndex);
  };

  return {
    fields,
    append,
    handleDelete,
    handleMove,
  };
};
