import { Component, Input, OnInit } from '@angular/core';
import { Student } from '../../../models/models';
import { StudentService } from '../../../students/student.service';
import { LessonService } from '../../lesson.service';

@Component({
  selector: 'app-student-list-for-lesson',
  templateUrl: './student-list-for-lesson.component.html',
  styleUrls: ['./student-list-for-lesson.component.css'],
})
export class StudentListForLessonComponent implements OnInit {
  @Input() lessonId: string;
  students: Student[];
  loading = false;
  newStudent = {} as Student;

  constructor(
    private studentService: StudentService,
    private lessonService: LessonService
  ) {}

  ngOnInit(): void {
    if (this.lessonId) {
      this.reload();
    }
  }

  reload(): void {
    this.lessonService.getLessonById(this.lessonId).subscribe((lesson) => {
      // TODO: Fetch students for lesson endpoint
      this.fetchStudents(lesson);
    });
  }

  private fetchStudents(lesson): void {
    this.students = [];
    lesson.studentIds.forEach((studentId) => {
      this.studentService.getStudentById(studentId).subscribe((student) => {
        this.students.push(student);
      });
      this.loading = false;
    });
  }
}
