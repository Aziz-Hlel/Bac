import {
  type CityEnum,
  type SessionEnum,
  type SubjectEnum,
  type PrefixEnumType,
  type AssignmentRoleEnum,
  type OptionalSubjectEnum,
  type MajorEnum,
  type OAuthProvider,
  type TermEnum,
  type SubjectTypeEnum,
  type SubjectEnumsType,
  type RoleEnum,
} from './rest';

export const CityEnumsMapping: Record<CityEnum, string> = {
  SOUSSE: 'Sousse',
  TUNIS: 'Tunis',
  TOZEUR: 'Tozeur',
  ZARZIS: 'Zarzis',
  NABEUL: 'Nabeul',
};

export const SessionEnumsMapping: Record<SessionEnum, string> = {
  MORNING: 'Morning',
  EVENING: 'Evening',
};

export const SubjectMapping: Record<SubjectEnum, string> = {
  MATH: 'Math',
  SCIENCE: 'Science',
  ENGLISH: 'English',
  FRENCH: 'French',
  HISTORY: 'History',
  GEOGRAPHY: 'Geography',
  BIOLOGY: 'Biology',
  CHEMISTRY: 'Chemistry',
  PHYSICS: 'Physics',
  SPANISH: 'Spanish',
  ITALIAN: 'Italian',
  GERMAN: 'German',
};

export const PrefixEnumMapping: Record<PrefixEnumType, string> = {
  MADAME: 'Madame',
  MISS: 'Miss',
  MR: 'Mr',
  MRS: 'Mrs',
};

export const AssignmentRoleMapping: Record<AssignmentRoleEnum, string> = {
  PRIMARY: 'Primary',
  SECONDARY: 'Secondary',
};

export const OptionalSubjectEnumsMapping: Record<OptionalSubjectEnum, string> = {
  SPANISH: 'Spanish',
  ITALIAN: 'Italian',
  GERMAN: 'German',
};

export const MajorEnumsMapping: Record<MajorEnum, string> = {
  MATH: 'Math',
  SCIENCE: 'Science',
  LETTRE: 'Lettre',
  TECHNIQUE: 'Technique',
  ECO: 'Eco',
  INFORMATIQUE: 'Informatique',
  SPORT: 'Sport',
};

export const OAuthProvidersMapping: Record<OAuthProvider, string> = {
  GOOGLE: 'Google',
  FACEBOOK: 'Facebook',
  APPLE: 'Apple',
};

export const TermEnumsMapping: Record<TermEnum, string> = {
  PRINCIPAL: 'Principal',
  RETAKE: 'Retake',
};

export const SubjectTypeMapping: Record<SubjectTypeEnum, string> = {
  REQUIRED: 'Required',
  OPTIONAL: 'Optional',
};

export const SubjectEnumsMapping: Record<SubjectEnumsType, string> = {
  MATH: 'Math',
  SCIENCE: 'Science',
  ENGLISH: 'English',
  FRENCH: 'French',
  HISTORY: 'History',
  GEOGRAPHY: 'Geography',
  BIOLOGY: 'Biology',
  CHEMISTRY: 'Chemistry',
  PHYSICS: 'Physics',
  SPANISH: 'Spanish',
  ITALIAN: 'Italian',
  GERMAN: 'German',
};

export const RoleEnumsMapping: Record<RoleEnum, string> = {
  ADMIN: 'Admin',
  SUPER_ADMIN: 'Super Admin',
};
