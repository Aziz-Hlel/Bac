import { useUser } from '@/context/UserConext';

const OnboardingForms = () => {
  const user = useUser();

  if (user.onboarding.completed) {
    throw new Error('User has already completed onboarding and should not access onboarding forms.');
  }
};

export default OnboardingForms;
