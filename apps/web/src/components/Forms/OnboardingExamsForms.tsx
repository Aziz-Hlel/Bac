import { schoolExamsSchema, type SchoolExams } from '@/types/onboard/schoolExams';
import { zodResolver } from '@hookform/resolvers/zod/dist/zod.js';
import { Card, CardContent } from '@/components/ui/card';
import { FieldGroup } from '@/components/ui/field';
import { Label } from '../ui/label';
import ExamFormContent from './ExamFormContent';
import { MajorEnums, type MajorEnum } from '@/enums/rest';
import { useForm } from 'react-hook-form';

const OnboardingExamsForms = () => {
  const form = useForm<SchoolExams>({
    resolver: zodResolver(schoolExamsSchema),
    defaultValues: {
      schoolMajors: [],
      schoolOptionalSubjects: [],
    },
  });
  const formId = 'onboarding-exams-form';

  const onSubmit = (data: SchoolExams) => {
    console.log(data);
  };
  return (
    <>
      <div className={'flex flex-col gap-6 w-1/2 '}>
        <Card className="overflow-hidden p-0">
          <CardContent className="grid p-0 md:grid-cols-2">
            <form className="p-6 md:p-8" id={formId} onSubmit={form.handleSubmit(onSubmit)}>
              <Label>Selecter les branches passes dans votre etablisment</Label>
              {Object.keys(MajorEnums).map((major) => (
                <ExamFormContent key={major} form={form} examType={major as MajorEnum} />
              ))}
              <FieldGroup></FieldGroup>
            </form>
          </CardContent>
        </Card>
      </div>
    </>
  );
};

export default OnboardingExamsForms;
