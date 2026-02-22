import type { SchoolExams } from '@/types/onboard/schoolExams';
import React from 'react';
import { useFieldArray, type UseFormReturn } from 'react-hook-form';
import { Checkbox } from '../ui/checkbox';
import { Label } from '../ui/label';
import { type OptionalSubjectEnum } from '@/enums/rest';
import { Input } from '../ui/input';
import type { CheckedState } from '@radix-ui/react-checkbox';
import { OptionalSubjectEnumsMapping } from '@/enums/EnumMapping';

interface OptionalExamsFormContentProps {
  form: UseFormReturn<SchoolExams>;
  examType: OptionalSubjectEnum;
}

const OptionalExamsFormContent = ({ form, examType }: OptionalExamsFormContentProps) => {
  const { fields, append, remove, update } = useFieldArray({
    control: form.control,
    name: 'schoolOptionalSubjects',
  });

  const majorIndex = fields.findIndex((field) => {
    return field.optionalSubject === examType;
  });
  const isMajorSelected = majorIndex !== -1;

  const majorNumberClasses = isMajorSelected ? fields[majorIndex].classNumber : 0;

  const addMajor = () => {
    append({
      optionalSubject: examType,
      classNumber: 1,
      term: 'PRINCIPAL',
    });
  };
  const removeMajor = () => {
    if (majorIndex !== -1) {
      remove(majorIndex);
    }
  };

  const handleCheckboxChange = (checked: CheckedState) => {
    if (checked) {
      addMajor();
    } else {
      removeMajor();
    }
  };

  const handleClassNumberChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const value = parseInt(e.target.value, 10);
    if (majorIndex !== -1) {
      update(majorIndex, {
        optionalSubject: examType,
        classNumber: isNaN(value) ? 1 : value,
        term: 'PRINCIPAL',
      });
    }
  };
  return (
    <>
      <>
        <Label className="hover:bg-accent/50 flex items-start gap-3 rounded-lg border p-3 has-[[aria-checked=true]]:border-blue-600 has-[[aria-checked=true]]:bg-blue-50 dark:has-[[aria-checked=true]]:border-blue-900 dark:has-[[aria-checked=true]]:bg-blue-950">
          <Checkbox
            // id="toggle-2"
            checked={isMajorSelected}
            onCheckedChange={handleCheckboxChange}
            className="data-[state=checked]:border-blue-600 data-[state=checked]:bg-blue-600 data-[state=checked]:text-white dark:data-[state=checked]:border-blue-700 dark:data-[state=checked]:bg-blue-700"
          />
          <div className="grid gap-1.5 font-normal">
            <p className="text-sm leading-none font-medium">{OptionalSubjectEnumsMapping[examType]}</p>
            <Input
              className=""
              disabled={!isMajorSelected}
              value={majorNumberClasses}
              onChange={handleClassNumberChange}
            />
            {form.formState.errors.schoolOptionalSubjects?.[majorIndex]?.classNumber && (
              <p className="text-red-500 text-sm">
                {form.formState.errors.schoolOptionalSubjects?.[majorIndex]?.classNumber?.message}
              </p>
            )}
          </div>
        </Label>
      </>
    </>
  );
};

export default OptionalExamsFormContent;
