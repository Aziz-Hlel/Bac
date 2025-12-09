import type { User } from '../user/user';
import type { OnboardingResponse } from './onboardingResponse';

export type UserProfile = User & {
  onboarding: OnboardingResponse;
};
