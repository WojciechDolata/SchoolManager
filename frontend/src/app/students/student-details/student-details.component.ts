import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Student} from '../../models/models';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css'],
})
export class StudentDetailsComponent implements OnInit {
  private id: string;
  student: Student;

  constructor(
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
      .subscribe((student) => (this.student = student));
  }
}
