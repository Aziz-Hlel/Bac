import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import Home from './pages/Home';
import SignUp from './pages/SignUp';
import NotFound from './pages/NotFound';
import AuthenticatedRoutes from './guard/AuthenticatedRoutes';
import Profile from './pages/Profile';
import { AuthProvider } from './context/AuthContext';
import SignIn from './components/SignIn/SignIn';
import NetworkStatusGuard from './guard/NetworkStatusGuard';
import { Toaster } from 'sonner';
import SideBar from './pages/Sidebar';
import { UserSessionProvider } from './context/UserConext';
import UserPage from './pages/User';
import OnboardingGuard from './guard/OnboardingGuard';
import OnboardingExamsForms from './components/OnboardingForms/OnboardingExamsForms';
import TeachersMainPage from './pages/TeachersMainPage';
import Teachers2 from './pages/Teachers2';

const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      refetchOnWindowFocus: false,
      retry: 1,
    },
  },
});

function App() {
  const dir: 'rtl' | 'ltr' = 'ltr';
  return (
    <div dir={dir}>
      <Toaster />
      <QueryClientProvider client={queryClient}>
        <NetworkStatusGuard>
          {/* <SidebarProvider> */}
          <Router>
            <AuthProvider>
              <Routes>
                <Route path="/signin" element={<SignIn />} />
                <Route path="/signup" element={<SignUp />} />

                <Route element={<AuthenticatedRoutes />}>
                  <Route element={<UserSessionProvider />}>
                    <Route path="/on-boarding">
                      <Route path="school-details" element={<div>Onboarding Step 1</div>} />
                      <Route path="school-exams" element={<OnboardingExamsForms />} />
                    </Route>
                    <Route element={<OnboardingGuard />}>
                      <Route element={<SideBar dir={dir} />}>
                        <Route path="/" element={<Home />} />
                        <Route index path="/profile" element={<Profile />} />

                        <Route path="users/" element={<UserPage />}></Route>
                        <Route path="teachers/" element={<TeachersMainPage />}></Route>
                        <Route path="teachers2/" element={<Teachers2 />}></Route>
                      </Route>
                    </Route>
                  </Route>
                </Route>

                <Route path="*" element={<NotFound />} />
              </Routes>
            </AuthProvider>
          </Router>
          {/* </SidebarProvider> */}
        </NetworkStatusGuard>
      </QueryClientProvider>
    </div>
  );
}

export default App;
