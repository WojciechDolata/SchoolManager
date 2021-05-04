import { EducationYear, Lesson } from '../models/models';

export function castFormToLesson(form): Lesson {
  console.log(form);
  const lesson = form.value as Lesson;
  const beginningDate = new Date(form.value.beginningDate);
  const endDate = new Date(beginningDate.getMilliseconds());
  const beginningHour = new Hour(form.value.beginningHour);
  const endHour = new Hour(form.value.endHour);
  beginningDate.setHours(beginningHour.getHours(), beginningHour.getMinutes());
  endDate.setHours(endHour.getHours(), endHour.getMinutes());
  lesson.beginningDate = beginningDate;
  lesson.endDate = endDate;
  return lesson;
}

export class Hour {
  time: string;

  constructor(time: string) {
    this.time = time;
  }

  public getHours(): number {
    return +this.time[0] * 10 + +this.time[1];
  }

  public getMinutes(): number {
    return +this.time[3] * 10 + +this.time[4];
  }
}

export function yearsComparator(y1: EducationYear, y2: EducationYear): number {
  return y1.schoolYear > y2.schoolYear ? 1 : -1;
}
