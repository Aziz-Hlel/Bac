import type { ControllerRenderProps, FieldValues, Path } from 'react-hook-form';
import {
  Select,
  SelectContent,
  SelectGroup,
  SelectItem,
  SelectLabel,
  SelectTrigger,
  SelectValue,
} from '../../ui/select';

type SelectFormProps<T extends FieldValues> = {
  field: ControllerRenderProps<T, Path<T>>;
  options: Record<string, string>;
  placeholder: string;
  label: string;
  props?: React.ComponentProps<typeof Select>;
};

const SelectForm = <T extends FieldValues>({ field, options, placeholder, label, props }: SelectFormProps<T>) => {
  return (
    <Select {...field} onValueChange={field.onChange} {...props}>
      <SelectTrigger className="w-45">
        <SelectValue placeholder={placeholder} />
      </SelectTrigger>

      <SelectContent>
        <SelectGroup>
          <SelectLabel>{label}</SelectLabel>

          {Object.entries(options).map(([key, value]) => {
            return (
              <SelectItem key={key} value={key}>
                {value}
              </SelectItem>
            );
          })}
        </SelectGroup>
      </SelectContent>
    </Select>
  );
};

export default SelectForm;
