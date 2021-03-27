export interface Student {
  id: string;
  nick: string;
  firstName: string;
  lastName: string;
  city: string;
  phoneNumber: string;
  email: string;
  facebook: string;
  whatsapp: string;
  birthDate: Date;
  nameDay: Date;
  since: Date;
  description: string;
}

export interface Page<T> {
  content: T[];
  last: boolean;
  numberOfElements: number;
  totalPages: number;
}

export interface School {
  id: string;
  name: string;
  street: string;
  city: string;
  level: EducationLevel;
}

export enum EducationLevel {
  HIGH_SCHOOL = 'Liceum',
  PRIMARY_SCHOOL = 'Szkoła podstawowa',
  UNIVERSITY = 'Studia',
}

export interface Parent {
  id: string;
  firstName: string;
  lastName: string;
  city: string;
  phoneNumber: string;
  email: string;
  facebook: string;
  whatsapp: string;
  birthDate: Date;
  nameDay: Date;
  description: string;
  studentId: string;
}

export interface EducationYear {
  id: string;
  schoolYear: string;
  classNumber: number;
  description: string;
  schoolId: string;
  school: School;
  studentId: string;
}

export interface EducationPlan {
  id: string;
  topic: string;
  educationYearId: string;
  subjectId: string;
  subject: Subject;
}

export interface Lesson {
  id: string;
  beginningDate: Date;
  endDate: Date;
  description: string;
  topic: string;
  subject: Subject;
  studentIds: string[];
}

export interface Subject {
  id: string;
  name: string;
}

export function getMockYear(): EducationYear {
  return {
    schoolYear: '2015/2016',
    classNumber: 1,
    school: {} as School,
  } as EducationYear;
}
