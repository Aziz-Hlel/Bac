// CityEnums.ts
export const CityEnums = {
  SOUSSE: 'SOUSSE',
  TUNIS: 'TUNIS',
  TOZEUR: 'TOZEUR',
  ZARZIS: 'ZARZIS',
  NABEUL: 'NABEUL',
} as const;

export type CityEnum = keyof typeof CityEnums;

// SessionEnums.ts
export const SessionEnums = {
  MORNING: 'MORNING',
  EVENING: 'EVENING',
} as const;

export type SessionEnum = keyof typeof SessionEnums;

// Subject.ts
export const Subject = {
  MATH: 'MATH',
  SCIENCE: 'SCIENCE',
  ENGLISH: 'ENGLISH',
  FRENCH: 'FRENCH',
  HISTORY: 'HISTORY',
  GEOGRAPHY: 'GEOGRAPHY',
  BIOLOGY: 'BIOLOGY',
  CHEMISTRY: 'CHEMISTRY',
  PHYSICS: 'PHYSICS',
  SPANISH: 'SPANISH',
  ITALIAN: 'ITALIAN',
  GERMAN: 'GERMAN',
} as const;

export type SubjectEnum = keyof typeof Subject;

// PrefixEnum.ts
export const PrefixEnum = {
  MADAME: 'MADAME',
  MISS: 'MISS',
  MR: 'MR',
  MRS: 'MRS',
} as const;

export type PrefixEnumType = keyof typeof PrefixEnum;

// AssignmentRole.ts
export const AssignmentRole = {
  PRIMARY: 'PRIMARY',
  SECONDARY: 'SECONDARY',
} as const;

export type AssignmentRoleEnum = keyof typeof AssignmentRole;

// OptionalSubjectEnums.ts
export const OptionalSubjectEnums = {
  SPANISH: 'SPANISH',
  ITALIAN: 'ITALIAN',
  GERMAN: 'GERMAN',
} as const;

export type OptionalSubjectEnum = keyof typeof OptionalSubjectEnums;

// MajorEnums.ts
export const MajorEnums = {
  MATH: 'MATH',
  SCIENCE: 'SCIENCE',
  LETTRE: 'LETTRE',
  TECHNIQUE: 'TECHNIQUE',
  ECO: 'ECO',
  INFORMATIQUE: 'INFORMATIQUE',
  SPORT: 'SPORT',
} as const;

export type MajorEnum = keyof typeof MajorEnums;

// OAuthProviders.ts
export const OAuthProviders = {
  GOOGLE: 'GOOGLE',
  FACEBOOK: 'FACEBOOK',
  APPLE: 'APPLE',
} as const;

export type OAuthProvider = keyof typeof OAuthProviders;

// TermEnums.ts
export const TermEnums = {
  PRINCIPAL: 'PRINCIPAL',
  RETAKE: 'RETAKE',
} as const;

export type TermEnum = keyof typeof TermEnums;

// SubjectType.ts
export const SubjectType = {
  REQUIRED: 'REQUIRED',
  OPTIONAL: 'OPTIONAL',
} as const;

export type SubjectTypeEnum = keyof typeof SubjectType;

// SubjectEnums.ts
export const SubjectEnums = {
  MATH: 'MATH',
  SCIENCE: 'SCIENCE',
  ENGLISH: 'ENGLISH',
  FRENCH: 'FRENCH',
  HISTORY: 'HISTORY',
  GEOGRAPHY: 'GEOGRAPHY',
  BIOLOGY: 'BIOLOGY',
  CHEMISTRY: 'CHEMISTRY',
  PHYSICS: 'PHYSICS',
  SPANISH: 'SPANISH',
  ITALIAN: 'ITALIAN',
  GERMAN: 'GERMAN',
} as const;

export type SubjectEnumsType = keyof typeof SubjectEnums;

// RoleEnums.ts
export const RoleEnums = {
  ADMIN: 'ADMIN',
  SUPER_ADMIN: 'SUPER_ADMIN',
} as const;

export type RoleEnum = keyof typeof RoleEnums;
