import { useUser } from '@/context/UserConext';
import { Navigate, Outlet } from 'react-router-dom';

const onboardingPaths = ['/onboarding/step-1', '/on-boarding/school-exams', '/onboarding/step-3'];

const OnboardingGuard = () => {
  const user = useUser();

  if (!user.onboarding.completed) {
    return <Navigate to={onboardingPaths[user.onboarding.step]} replace />;
  }

  return <Outlet />;
};

export default OnboardingGuard;
