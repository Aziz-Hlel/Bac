import { apiService } from '@/Api/apiService';
import apiRoutes from '../routes/routes';
import type { FirebaseSignInRequestDto } from '@/types/auth/SignInRequestDto';
import type { ApiResponse } from '../../types/api/ApiResponse';
import type { FirebaseSignUpRequestSchema } from '@/types/auth/SignUpRequestDto';
import type { RefreshRequestDto } from '@/types/auth/RefreshRequestDto';
import type { UserProfile } from '@/types/auth/UserProfile';

export interface IauthService {
  signIn: (payload: FirebaseSignInRequestDto) => Promise<ApiResponse<UserProfile>>;

  signUp: (payload: FirebaseSignUpRequestSchema) => Promise<ApiResponse<UserProfile>>;

  oAuthSignIn: (payload: FirebaseSignInRequestDto) => Promise<ApiResponse<UserProfile>>;

  me: () => Promise<ApiResponse<UserProfile>>;

  refresh: (payload: RefreshRequestDto) => Promise<ApiResponse<UserProfile>>;
}

export const authService: IauthService = {
  signIn: (payload) => {
    return apiService.post(apiRoutes.auth.signIn(), payload);
  },
  signUp: (payload) => {
    return apiService.post(apiRoutes.auth.signUp(), payload);
  },
  oAuthSignIn: (payload) => {
    return apiService.post(apiRoutes.auth.oAuthSignIn(), payload);
  },
  me: () => {
    return apiService.get(apiRoutes.auth.me());
  },
  refresh: (payload) => {
    return apiService.post(apiRoutes.auth.refresh(), payload);
  },
};
