import {Component, OnInit} from '@angular/core';
import {StudentService} from '../student.service';
import {EducationYear, getMockYear, School} from '../../models/models';
import {ActivatedRoute} from '@angular/router';
import {CommonService} from '../../common/common.service';
import {schoolYears} from '../../common/schoolYears';

@Component({
  selector: 'app-education-years',
  templateUrl: './education-years.component.html',
  styleUrls: ['./education-years.component.css']
})
export class EducationYearsComponent implements OnInit {
  private id: string;
  educationYears: EducationYear[];
  schools: School[];
  newEducationYear = getMockYear();

  constructor(private studentService: StudentService,
              private commonService: CommonService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.reloadData();
    this.commonService.getAllSchools().subscribe(data => this.schools = data);
  }

  reloadData(): void {
    this.studentService
      .getEducationYearsFor(this.id)
      .subscribe(data => this.educationYears = data);
  }

  addEducationYear(): void {
    this.newEducationYear.studentId = this.id;
    this.newEducationYear.schoolId = this.newEducationYear.school.id;
    this.studentService.addEducationYear(this.newEducationYear).subscribe(
      () => this.reloadData()
    );
    this.newEducationYear = getMockYear();
  }

  getSchoolYears(): string[] {
    return schoolYears;
  }

  getPossibleClasses(): number[] {
    if (this.newEducationYear.school) {
      // typescript string enums seem not to work in switch statement
      if (this.newEducationYear.school.level as string === 'HIGH_SCHOOL') {
        return [1, 2, 3];
      } else {
        return [1, 2, 3, 4 , 5, 6, 7, 8];
      }
    }
    return [];
  }

}
