import type { SchoolExams } from '@/types/onboard/schoolExams';
import React from 'react';
import { Controller, useFieldArray, type UseFormReturn } from 'react-hook-form';
import { useGetArray } from './use-Get-Array';
import { Checkbox } from '../ui/checkbox';
import { Label } from '../ui/label';
import { MajorEnums, type MajorEnum, type OptionalSubjectEnum } from '@/enums/rest';
import { Input } from '../ui/input';
import { Field, FieldLabel } from '../ui/field';
import type { CheckedState } from '@radix-ui/react-checkbox';
import { MajorEnumsMapping } from '@/enums/EnumMapping';

interface ExamFormContentProps {
  form: UseFormReturn<SchoolExams>;
  examType: MajorEnum;
}

const ExamFormContent = ({ form, examType }: ExamFormContentProps) => {
  const { fields, append, remove, update } = useFieldArray({
    control: form.control,
    name: 'schoolMajors',
  });

  const majorIndex = fields.findIndex((field) => {
    return field.majorName === examType;
  });
  const isMajorSelected = majorIndex !== -1;
  const majorNumberClasses = isMajorSelected ? fields[majorIndex].classNumber : 0;

  const addMajor = () => {
    append({
      majorName: examType,
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
        majorName: examType,
        classNumber: isNaN(value) ? 1 : value,
        term: 'PRINCIPAL',
      });
    }
  };
  return (
    <>
      <>
        <Label className="hover:bg-accent/50 flex items-start gap-3 rounded-lg border p-3 has-[[aria-checked=true]]:border-blue-600 has-[[aria-checked=true]]:bg-blue-50 dark:has-[[aria-checked=true]]:border-blue-900 dark:has-[[aria-checked=true]]:bg-blue-950">
          <div className=" flex  items-center gap-4">
            <Checkbox
              // id="toggle-2"
              checked={isMajorSelected}
              onCheckedChange={handleCheckboxChange}
              className="data-[state=checked]:border-blue-600 data-[state=checked]:bg-blue-600 data-[state=checked]:text-white dark:data-[state=checked]:border-blue-700 dark:data-[state=checked]:bg-blue-700"
            />
            <p className="text-sm leading-none font-medium">{MajorEnumsMapping[examType]}</p>
            <Input disabled={!isMajorSelected} value={majorNumberClasses} onChange={handleClassNumberChange} />
            {form.formState.errors.schoolMajors?.[majorIndex]?.classNumber && (
              <p className="text-red-500 text-sm">
                {form.formState.errors.schoolMajors?.[majorIndex]?.classNumber?.message}
              </p>
            )}
          </div>
        </Label>
      </>
    </>
  );
};

export default ExamFormContent;
