// CityEnums.ts
export const CityEnums = {
  SOUSSE: 'SOUSSE',
  TUNIS: 'TUNIS',
  TOZEUR: 'TOZEUR',
  ZARZIS: 'ZARZIS',
  NABEUL: 'NABEUL',
} as const;

export type CityEnum = (typeof CityEnums)[keyof typeof CityEnums];

// SessionEnums.ts
export const SessionEnums = {
  MORNING: 'MORNING',
  EVENING: 'EVENING',
} as const;

export type SessionEnum = (typeof SessionEnums)[keyof typeof SessionEnums];

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

export type SubjectEnum = (typeof Subject)[keyof typeof Subject];

// PrefixEnum.ts
export const PrefixEnum = {
  MADAME: 'MADAME',
  MISS: 'MISS',
  MR: 'MR',
  MRS: 'MRS',
} as const;

export type PrefixEnumType = (typeof PrefixEnum)[keyof typeof PrefixEnum];

// AssignmentRole.ts
export const AssignmentRole = {
  PRIMARY: 'PRIMARY',
  SECONDARY: 'SECONDARY',
} as const;

export type AssignmentRoleEnum = (typeof AssignmentRole)[keyof typeof AssignmentRole];

// OptionalSubjectEnums.ts
export const OptionalSubjectEnums = {
  SPANISH: 'SPANISH',
  ITALIAN: 'ITALIAN',
  GERMAN: 'GERMAN',
} as const;

export type OptionalSubjectEnum = (typeof OptionalSubjectEnums)[keyof typeof OptionalSubjectEnums];

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
  GOOGLE: 'GOOGLE',
  FACEBOOK: 'FACEBOOK',
  APPLE: 'APPLE',
} as const;

export type OAuthProvider = (typeof OAuthProviders)[keyof typeof OAuthProviders];

// TermEnums.ts
export const TermEnums = {
  PRINCIPAL: 'PRINCIPAL',
  RETAKE: 'RETAKE',
} as const;

export type TermEnum = (typeof TermEnums)[keyof typeof TermEnums];

// SubjectType.ts
export const SubjectType = {
  REQUIRED: 'REQUIRED',
  OPTIONAL: 'OPTIONAL',
} as const;

export type SubjectTypeEnum = (typeof SubjectType)[keyof typeof SubjectType];

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

export type SubjectEnumsType = (typeof SubjectEnums)[keyof typeof SubjectEnums];

// RoleEnums.ts
export const RoleEnums = {
  ADMIN: 'ADMIN',
  SUPER_ADMIN: 'SUPER_ADMIN',
} as const;

export type RoleEnum = (typeof RoleEnums)[keyof typeof RoleEnums];
