import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import {
  EducationLevel,
  EducationYear,
  getMockYear,
  School,
} from '../../models/models';
import { ActivatedRoute } from '@angular/router';
import { CommonService } from '../../common/common.service';
import { schoolYears } from '../../common/schoolYears';

@Component({
  selector: 'app-education-years',
  templateUrl: './education-years.component.html',
  styleUrls: ['./education-years.component.css'],
})
export class EducationYearsComponent implements OnInit {
  private id: string;

  educationYears: EducationYear[];
  schools: School[];
  newEducationYear = getMockYear();
  selectedIndex: number;
  selectedEducationYear: EducationYear;

  constructor(
    private studentService: StudentService,
    private commonService: CommonService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.reloadEducationYears();
    this.reloadSchools();
  }

  reloadEducationYears(): void {
    this.studentService
      .getEducationYearsFor(this.id)
      .subscribe((data) => (this.educationYears = data));
  }

  reloadSchools(): void {
    this.commonService
      .getAllSchools()
      .subscribe((data) => (this.schools = data));
  }

  addEducationYear(): void {
    this.newEducationYear.studentId = this.id;
    this.newEducationYear.schoolId = this.newEducationYear.school.id;
    this.studentService
      .addEducationYear(this.newEducationYear)
      .subscribe(() => this.reloadEducationYears());
    this.newEducationYear = getMockYear();
  }

  select(index: number): void {
    this.selectedIndex = index;
    console.log(index);
    this.selectedEducationYear = this.educationYears[index];
  }

  getSchoolYears(): string[] {
    return schoolYears;
  }

  getPossibleClasses(): number[] {
    if (this.newEducationYear.school) {
      switch (this.newEducationYear.school.level) {
        case EducationLevel.HIGH_SCHOOL:
          return this.getArrayOneToN(3);
        case EducationLevel.PRIMARY_SCHOOL:
          return this.getArrayOneToN(8);
        case EducationLevel.UNIVERSITY:
          return this.getArrayOneToN(5);
      }
      if (this.newEducationYear.school.level === EducationLevel.HIGH_SCHOOL) {
        return [1, 2, 3];
      } else {
        return [1, 2, 3, 4, 5, 6, 7, 8];
      }
    }
    return [];
  }

  private getArrayOneToN(n: number): number[] {
    return [...Array(n).keys()].map((i) => i + 1);
  }
}
