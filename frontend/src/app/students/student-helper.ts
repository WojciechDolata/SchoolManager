import { EducationYear, Student } from '../models/models';

export function castFormToStudent(form): Student {
  const student = form.value as Student;
  student.birthDate = form.value.birthDate as Date;
  student.since = form.value.since as Date;
  student.nameDay = form.value.nameDay as Date;
  return student;
}

export function yearsComparator(y1: EducationYear, y2: EducationYear): number {
  return y1.schoolYear > y2.schoolYear ? 1 : -1;
}
