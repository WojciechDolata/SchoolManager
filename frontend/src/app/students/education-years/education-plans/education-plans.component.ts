import {
  Component,
  Input,
  OnChanges,
  OnInit,
  SimpleChanges,
} from '@angular/core';
import { EducationPlan, EducationYear, Subject } from '../../../models/models';
import { CommonService } from '../../../common/common.service';
import { StudentService } from '../../student.service';

@Component({
  selector: 'app-education-plans',
  templateUrl: './education-plans.component.html',
  styleUrls: ['./education-plans.component.css'],
})
export class EducationPlansComponent implements OnInit, OnChanges {
  @Input() public educationYear: EducationYear;

  educationPlans: EducationPlan[] = [];
  newEducationPlan: EducationPlan = {} as EducationPlan;
  subjects: Subject[] = [];

  constructor(
    private commonService: CommonService,
    private studentService: StudentService
  ) {}

  ngOnInit(): void {
    this.loadSubjects();
    this.resetData();
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.resetData();
  }

  resetData(): void {
    if (this.educationYear) {
      this.educationPlans = [];
      this.loadEducationPlans();
    }
  }

  loadEducationPlans(): void {
    this.studentService
      .getEducationPlansFor(this.educationYear.id)
      .subscribe((data) => (this.educationPlans = data));
  }

  loadSubjects(): void {
    this.commonService.getAllSubjects().subscribe((subjects) => {
      this.subjects = subjects;
    });
  }

  addEducationPlan(): void {
    this.newEducationPlan.subjectId = this.newEducationPlan.subject.id;
    this.newEducationPlan.educationYearId = this.educationYear.id;
    this.studentService
      .addEducationPlan(this.newEducationPlan)
      .subscribe(() => this.loadEducationPlans());
  }
}
