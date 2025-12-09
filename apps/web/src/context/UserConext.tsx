import { createContext, useContext } from 'react';
import { useAuth } from './AuthContext';
import { Outlet } from 'react-router-dom';
import type { UserProfile } from '@/types/auth/UserProfile';

const UserSessionContext = createContext<UserProfile | undefined>(undefined);

export function UserSessionProvider() {
  const { user } = useAuth();

  if (!user) return <> User still not defined when passed through UserProvider Context </>;

  return (
    <UserSessionContext.Provider value={user}>
      <Outlet />
    </UserSessionContext.Provider>
  );
}

export const useUser = (): UserProfile => {
  const user = useContext(UserSessionContext);

  if (user === undefined) {
    throw new Error('useUser must be used within a UserProvider');
  }

  return user;
};
