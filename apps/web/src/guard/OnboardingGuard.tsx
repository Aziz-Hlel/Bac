import { useUser } from '@/context/UserConext';
import { Navigate, Outlet } from 'react-router-dom';

type OnboardingPathProps = {
  name: string;
  path: string;
};

const onboardingNavigationPaths: OnboardingPathProps[] = [
  {
    path: '/on-boarding/step-1',
    name: 'Register school',
  },
  { path: '/on-boarding/school-exams', name: 'School exams' },
  { path: '/on-boarding/step-3', name: 'Step 3' },
];

type OnboardingPathPropsWithNext = OnboardingPathProps & {
  next: () => OnboardingPathProps;
};
const homePath: OnboardingPathProps = {
  name: 'Home',
  path: '/',
};

export const OnBoardingPaths: OnboardingPathPropsWithNext[] = onboardingNavigationPaths.map((path, index, array) => {
  return {
    ...path,
    next: () => (index + 1 < array.length ? array[index + 1] : homePath),
  };
});

const OnboardingGuard = () => {
  const user = useUser();

  if (!user.onboarding.completed) {
    return <Navigate to={onboardingNavigationPaths[user.onboarding.step].path} replace />;
  }

  return <Outlet />;
};

export default OnboardingGuard;
