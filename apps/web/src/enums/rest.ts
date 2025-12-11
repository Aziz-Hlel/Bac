// CityEnums.ts
export const CityEnums = {
  SOUSSE: 'Sousse',
  TUNIS: 'Tunis',
  TOZEUR: 'Tozeur',
  ZARZIS: 'Zarzis',
  NABEUL: 'Nabeul',
} as const;

export type CityEnum = keyof typeof CityEnums;

// SessionEnums.ts
export const SessionEnums = {
  MORNING: 'Morning',
  EVENING: 'Evening',
} as const;

export type SessionEnum = keyof typeof SessionEnums;

// Subject.ts
export const Subject = {
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
} as const;

export type SubjectEnum = keyof typeof Subject;

// PrefixEnum.ts
export const PrefixEnum = {
  MADAME: 'Madame',
  MISS: 'Miss',
  MR: 'Mr',
  MRS: 'Mrs',
} as const;

export type PrefixEnumType = keyof typeof PrefixEnum;

// AssignmentRole.ts
export const AssignmentRole = {
  PRIMARY: 'Primary',
  SECONDARY: 'Secondary',
} as const;

export type AssignmentRoleEnum = keyof typeof AssignmentRole;

// OptionalSubjectEnums.ts
export const OptionalSubjectEnums = {
  SPANISH: 'Spanish',
  ITALIAN: 'Italian',
  GERMAN: 'German',
} as const;

export type OptionalSubjectEnum = keyof typeof OptionalSubjectEnums;

// MajorEnums.ts
export const MajorEnums = {
  MATH: 'Math',
  SCIENCE: 'Science',
  LETTRE: 'Lettre',
  TECHNIQUE: 'Technique',
  ECO: 'Eco',
  INFORMATIQUE: 'Informatique',
  SPORT: 'Sport',
} as const;

export type MajorEnum = keyof typeof MajorEnums;

// OAuthProviders.ts
export const OAuthProviders = {
  GOOGLE: 'Google',
  FACEBOOK: 'Facebook',
  APPLE: 'Apple',
} as const;

export type OAuthProvider = keyof typeof OAuthProviders;

// TermEnums.ts
export const TermEnums = {
  PRINCIPAL: 'Principal',
  RETAKE: 'Retake',
} as const;

export type TermEnum = keyof typeof TermEnums;

// SubjectType.ts
export const SubjectType = {
  REQUIRED: 'Required',
  OPTIONAL: 'Optional',
} as const;

export type SubjectTypeEnum = keyof typeof SubjectType;

// SubjectEnums.ts
export const SubjectEnums = {
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
} as const;

export type SubjectEnumsType = keyof typeof SubjectEnums;

// RoleEnums.ts
export const RoleEnums = {
  ADMIN: 'Admin',
  SUPER_ADMIN: 'Super Admin',
} as const;

export type RoleEnum = keyof typeof RoleEnums;
