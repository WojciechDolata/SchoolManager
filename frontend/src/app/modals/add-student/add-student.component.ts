import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Student } from '../../models/models';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { cities } from '../../common/cities';
import { Router } from '@angular/router';
import { StudentService } from '../../students/student.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css'],
})
export class AddStudentComponent implements OnInit {
  @ViewChild('closeButton') closeButton: ElementRef;

  newStudentForm: FormGroup;
  displayValidation = false;

  constructor(
    private formBuilder: FormBuilder,
    private studentService: StudentService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.newStudentForm = this.formBuilder.group({
      nick: '',
      firstName: new FormControl(null, Validators.required),
      lastName: '',
      city: '',
      phoneNumber: '',
      email: '',
      facebook: '',
      whatsapp: '',
      birthDate: null,
      nameDay: null,
      since: new Date(),
      description: '',
    });
  }

  getCities(): string[] {
    return cities;
  }

  getTodayDateAsString(): string {
    const date = new Date();
    return (
      date.getFullYear() +
      '-' +
      (date.getMonth() < 9 ? '0' : '') +
      (date.getMonth() + 1) +
      '-' +
      date.getDate()
    );
  }

  isNumberKey(evt): boolean {
    const charCode = evt.which ? evt.which : evt.keyCode;
    return (charCode > 47 && charCode < 58) || charCode === 43;
  }

  onSubmit(form): void {
    if (form.status === 'VALID') {
      const formValue = form.value;
      const student = {
        nick: formValue.nick,
        firstName: formValue.firstName,
        lastName: formValue.lastName,
        city: formValue.city,
        phoneNumber: formValue.phoneNumber,
        email: formValue.email,
        facebook: formValue.facebook,
        whatsapp: formValue.whatsapp,
        birthDate: formValue.birthDate,
        nameDay: formValue.nameDay,
        since: formValue.since,
        description: formValue.description,
      } as Student;
      this.studentService.addStudent(student).subscribe((newStudent) => {
        this.closeButton.nativeElement.click();
        this.router.navigate([`/student/${newStudent.id}/details`]);
      });
    } else {
      this.displayValidation = true;
    }
  }
}
