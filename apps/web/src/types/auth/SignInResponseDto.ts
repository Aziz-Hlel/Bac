import type { User } from '../user/user';
import type { OnboardingResponse } from './onboardingResponse';

export type SignInResponseDto = User & { onboarding: OnboardingResponse };
