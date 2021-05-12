import {
  Component,
  ElementRef,
  EventEmitter,
  Input,
  OnInit,
  Output,
  ViewChild,
} from '@angular/core';
import { StudentService } from '../../../students/student.service';
import { Student } from '../../../models/models';
import { LessonService } from '../../lesson.service';

@Component({
  selector: 'app-add-student-to-lesson',
  templateUrl: './add-student-to-lesson.component.html',
  styleUrls: ['./add-student-to-lesson.component.css'],
})
export class AddStudentToLessonComponent implements OnInit {
  @Input() lessonId: string;
  @Output() successfulAddition = new EventEmitter<any>();
  @ViewChild('closeButton') closeButton: ElementRef;

  studentSearch: string;
  selectedStudentId: string;
  studentsMatching: Student[];

  constructor(
    private studentService: StudentService,
    private lessonService: LessonService
  ) {}

  ngOnInit(): void {}

  findMatchingStudents(): void {
    this.studentService
      .getAllBy(0, this.studentSearch)
      .subscribe((page) => (this.studentsMatching = page.content));
  }

  addStudentToLesson(): void {
    this.lessonService
      .addStudentToLesson(this.lessonId, this.selectedStudentId)
      .subscribe(() => {
        this.goBack();
      });
  }

  private goBack(): void {
    this.closeButton.nativeElement.click();
    this.successfulAddition.emit();
  }
}
