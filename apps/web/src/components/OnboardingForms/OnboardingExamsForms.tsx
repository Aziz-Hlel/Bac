import { schoolExamsSchema, type SchoolExams } from '@/types/onboard/schoolExams';
import { zodResolver } from '@hookform/resolvers/zod/dist/zod.js';
import { Card, CardContent, CardFooter } from '@/components/ui/card';
import { Field, FieldGroup } from '@/components/ui/field';
import { Label } from '../ui/label';
import ExamFormContent from './ExamFormContent';
import { MajorEnums, OptionalSubjectEnums, type MajorEnum, type OptionalSubjectEnum } from '@/enums/rest';
import { useForm } from 'react-hook-form';
import OptionalExamsFormContent from './OptionalExamsFormContent';
import { Button } from '../ui/button';
import { toast } from 'sonner';
import { useUser } from '@/context/UserConext';
import { useMutation } from '@tanstack/react-query';
import { schoolExamsService } from '@/Api/service/schoolExamsService';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '@/context/AuthContext';

const OnboardingExamsForms = () => {
  const user = useUser();
  const { refreshUser } = useAuth();
  const navigate = useNavigate();
  const { mutateAsync } = useMutation({
    mutationFn: schoolExamsService.createSchoolExam,
    onSuccess: () => {
      toast.success('School exams saved successfully');
    },
    onError: () => {
      toast.error('Failed to save school exams, please contact us if the problem persists.');
    },
  });
  const form = useForm<SchoolExams>({
    resolver: zodResolver(schoolExamsSchema),
    defaultValues: {
      schoolMajors: [],
      schoolOptionalSubjects: [],
    },
  });
  const formId = 'onboarding-exams-form';

  const onSubmit = async (data: SchoolExams) => {
    if (data.schoolMajors.length === 0 || data.schoolOptionalSubjects.length === 0) {
      toast.warning('Please select at least one major and one optional subject.');
      return;
    }

    try {
      await mutateAsync({ schoolId: user.schoolId, payload: data });
      await refreshUser();
      navigate('/');
    } catch (_) {}
  };
  return (
    <>
      <div className=" mx-auto  w-full  flex justify-center py-12">
        <Card className="overflow-hidden p-8 w-1/2">
          <form className="p-6 md:p-8" id={formId} onSubmit={form.handleSubmit(onSubmit)}>
            <CardContent className=" mx-auto">
              <div className=" flex flex-col gap-4">
                <Label className=" text-xl">
                  Selecter les branches passes dans votre etablisment et saisie le nombre des classes
                </Label>
                {Object.keys(MajorEnums).map((major) => (
                  <ExamFormContent key={major} form={form} examType={major as MajorEnum} />
                ))}
              </div>
              <div className=" mt-8 flex flex-col gap-4">
                <Label className=" text-xl">Selecter les options passes dans votre etablisment</Label>
                {Object.keys(OptionalSubjectEnums).map((optionalSubject) => (
                  <OptionalExamsFormContent
                    key={optionalSubject}
                    form={form}
                    examType={optionalSubject as OptionalSubjectEnum}
                  />
                ))}
              </div>
              <Field orientation="horizontal"></Field>
            </CardContent>

            <CardFooter className=" bg-transparent border-t-0 px-0 pt-6 flex justify-end">
              <Button type="submit" className=" w-full text-lg px-4">
                Submit
              </Button>
            </CardFooter>
          </form>
        </Card>
      </div>
    </>
  );
};

export default OnboardingExamsForms;
