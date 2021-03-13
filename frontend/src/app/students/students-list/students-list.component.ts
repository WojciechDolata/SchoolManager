import { Component, OnInit } from '@angular/core';
import {StudentService} from '../student.service';
import {Student} from '../../models/models';

@Component({
  selector: 'app-students-list',
  templateUrl: './students-list.component.html',
  styleUrls: ['./students-list.component.css'],
})
export class StudentsListComponent implements OnInit {
  students: Student[];

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
    this.studentService.getAllStudents()
      .subscribe(students => this.students = students);
  }
}
