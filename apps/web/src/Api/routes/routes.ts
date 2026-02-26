import ENV from '@/config/env.variables';

const apiRoutes = {
  baseUrl: () => ENV.BASE_URL,
  health: () => '/health' as const,
  auth: {
    me: () => '/auth/me' as const,
    signIn: () => '/auth/login' as const,
    refresh: () => '/auth/refresh' as const,
    signUp: () => '/auth/register' as const,
    oAuthSignIn: () => '/auth/oauth/login' as const,
  },
  users: {
    getUsers: () => '/users' as const,
  },
  teachers: {
    getPage: () => '/teachers' as const,
    add: () => '/teachers' as const,
    update: () => '/teachers' as const,
    delete: () => '/teachers' as const,
  },

  services: {
    emailContactUs: () => '/services/email/contact-us' as const,
    emailProperty: () => '/services/email/property' as const,
  },

  schoolExams: {
    create: (schoolId: string) => `/schools/${schoolId}/school-classes` as const,
  },
  images: ENV.BASE_URL + '/images/',

  getSignedUrl: ENV.BASE_URL + '/images/getSignedUrl',
};

export default apiRoutes;
