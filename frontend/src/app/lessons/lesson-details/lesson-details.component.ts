import { Component, OnInit } from '@angular/core';
import { Lesson, Student, Subject } from '../../models/models';
import { LessonService } from '../lesson.service';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { StudentService } from '../../students/student.service';
import { convertDate, convertDateToFormat } from '../../common/common-helper';
import { castFormToLesson } from '../lesson-helper';
import { CommonService } from '../../common/common.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-lesson-details',
  templateUrl: './lesson-details.component.html',
  styleUrls: ['./lesson-details.component.css'],
})
export class LessonDetailsComponent implements OnInit {
  private lessonId: string;
  loading = true;
  isEditModeOn = false;
  lesson: Lesson;
  lessonAsForm: FormGroup;
  subjects: Subject[];
  newSubject: Subject = {} as Subject;

  constructor(
    private lessonService: LessonService,
    private studentService: StudentService,
    private commonService: CommonService,
    private formBuilder: FormBuilder,
    private router: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.fetchDetails();
  }

  private fetchDetails(): void {
    this.fetchSubjects();
    this.router.queryParamMap.subscribe((params) => {
      this.lessonId = params.get('id');
      this.setupForm();
    });
  }

  private fetchSubjects(): void {
    this.commonService.getAllSubjects().subscribe((s) => (this.subjects = s));
  }

  private setupForm(): void {
    if (this.lessonId) {
      this.fetchLessonDetailsAndUpdateForm();
    } else {
      this.setupFormAsEmpty();
      this.loading = false;
    }
  }

  private setupFormAsEmpty(): void {
    this.lessonAsForm = this.formBuilder.group({
      beginningDate: '',
      beginningHour: '',
      endHour: '',
      description: '',
      topic: '',
    });
  }

  private fetchLessonDetailsAndUpdateForm(): void {
    this.lessonService.getLessonById(this.lessonId).subscribe((lesson) => {
      this.updateForm(lesson);
      this.newSubject = this.subjects.filter(
        (s) => s.name === lesson.subjectName
      )[0];
      this.loading = false;
    });
  }

  private updateForm(lesson: Lesson = this.lesson): void {
    this.lesson = lesson;
    this.lessonId = lesson.id;
    this.lessonAsForm = this.formBuilder.group({
      beginningDate: convertDate(lesson.beginningDate),
      beginningHour: convertDateToFormat(lesson.beginningDate, 'HH:mm'),
      endHour: convertDateToFormat(lesson.endDate, 'HH:mm'),
      description: lesson.description,
      topic: lesson.topic,
    });
  }

  submitLesson(): void {
    const updatedLesson = this.createLessonFromForm();
    this.updateOrAddLesson(updatedLesson).subscribe((lesson) => {
      this.updateForm(lesson);
      this.changeEditMode();
    });
  }

  private createLessonFromForm(): Lesson {
    const formAsLesson = castFormToLesson(this.lessonAsForm);
    formAsLesson.subjectId = this.newSubject.id;
    formAsLesson.id = this.lessonId;
    return formAsLesson;
  }

  private updateOrAddLesson(updatedLesson: Lesson): Observable<Lesson> {
    if (this.lesson) {
      return this.lessonService.updateLesson(this.lessonId, updatedLesson);
    } else {
      return this.lessonService.addLesson(updatedLesson);
    }
  }

  editSwitch(): void {
    if (this.isEditModeOn) {
      this.updateForm();
    }
    this.changeEditMode();
  }

  private changeEditMode(): void {
    this.isEditModeOn = !this.isEditModeOn;
  }

  isSelected(subject: Subject): boolean {
    return this.newSubject ? this.newSubject.name === subject.name : false;
  }
}
