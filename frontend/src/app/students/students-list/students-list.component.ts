import { Component, HostListener, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import { Student } from '../../models/models';
import { FormBuilder } from '@angular/forms';
import { SortableHeaders } from '../../common/sortable-headers';
import { BasicList } from '../../common/basic-list/basic-list';

@Component({
  selector: 'app-students-list',
  templateUrl: './students-list.component.html',
  styleUrls: ['./students-list.component.css'],
})
export class StudentsListComponent
  extends BasicList<Student>
  implements OnInit {
  constructor(formBuilder: FormBuilder, studentService: StudentService) {
    super(
      formBuilder,
      studentService,
      new SortableHeaders(
        ['Imię', 'Nazwisko', 'Pseudonim', 'Miasto', 'Email', 'Numer telefonu'],
        ['firstName', 'lastName', 'nick', 'city', 'email', 'phoneNumber'],
        [10, 15, 20, 10, 30, 15]
      )
    );
  }

  ngOnInit(): void {
    this.init();
  }

  @HostListener('window:scroll', ['$event'])
  onScroll(event): void {
    this.loadNextIfPossible();
  }
}
