export interface Lesson {
  id: string;
  beginningDate: Date;
  endDate: Date;
  description: string;
  topic: string;
}

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
  studentId: string;
}

export interface EducationYear {
  id: string;
  topic: string;
  educationYearId: number;
  subjectId: string;
}


export interface Lesson {
  id: string;
  beginningDate: Date;
  endDate: Date;
  description: string;
  topic: string;
}

export interface Subject {
  id: string;
  name: string;
}
