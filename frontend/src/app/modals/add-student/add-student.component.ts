import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { cities } from '../../common/cities';
import { Router } from '@angular/router';
import { StudentService } from '../../students/student.service';
import { castFormToStudent } from '../../students/student-helper';
import { convertDate, isNumberKey } from '../../common/common-helper';

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
      birthDate: '',
      nameDay: '',
      since: convertDate(new Date()),
      description: '',
    });
  }

  getCities(): string[] {
    return cities;
  }

  isNumberKey(evt): boolean {
    return isNumberKey(evt);
  }

  onSubmit(form): void {
    if (form.status === 'VALID') {
      const student = castFormToStudent(form);
      this.studentService.addStudent(student).subscribe((newStudent) => {
        this.closeButton.nativeElement.click();
        this.router.navigate([`/student/${newStudent.id}/details`]);
      });
    } else {
      this.displayValidation = true;
    }
  }
}
