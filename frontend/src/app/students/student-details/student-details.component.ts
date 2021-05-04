import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Student } from '../../models/models';
import { StudentService } from '../student.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { castFormToStudent } from '../student-helper';
import { convertDate, isNumberKey } from '../../common/common-helper';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css'],
})
export class StudentDetailsComponent implements OnInit {
  private id: string;
  student: Student;
  studentAsForm: FormGroup;
  isEditModeOn = false;
  displayValidation = false;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private studentService: StudentService
  ) {}

  ngOnInit(): void {
    this.fetchDetails();
  }

  fetchDetails(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.studentService
      .getStudentById(this.id)
      .subscribe((student) => this.updateForm(student));
  }

  updateForm(student: Student): void {
    this.student = student;
    this.studentAsForm = this.formBuilder.group({
      nick: student.nick,
      firstName: [student.firstName, Validators.required],
      lastName: student.lastName,
      city: student.city,
      phoneNumber: student.phoneNumber,
      email: student.email,
      facebook: student.facebook,
      whatsapp: student.whatsapp,
      birthDate: convertDate(student.birthDate, true),
      nameDay: convertDate(student.nameDay, true),
      since: convertDate(student.since),
      description: student.description,
    });
  }

  submitForm(): void {
    if (this.studentAsForm.status === 'VALID') {
      const updatedStudent = castFormToStudent(this.studentAsForm);
      this.studentService
        .updateStudent(this.id, updatedStudent)
        .subscribe((student) => {
          this.updateForm(student);
          this.isEditModeOn = false;
          this.displayValidation = false;
        });
    } else {
      this.displayValidation = true;
    }
  }

  editSwitch(): void {
    if (this.isEditModeOn) {
      this.updateForm(this.student);
    }
    this.isEditModeOn = !this.isEditModeOn;
  }

  isNumberKey(evt): boolean {
    return isNumberKey(evt);
  }
}
