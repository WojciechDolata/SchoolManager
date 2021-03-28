import { Component, HostListener, OnInit } from '@angular/core';
import { Lesson } from '../../models/models';
import { LessonsService } from '../lessons.service';
import { SortableHeaders } from '../../common/sortable-headers';
import { FormBuilder } from '@angular/forms';
import { BasicList } from '../../common/basic-list/basic-list';

@Component({
  selector: 'app-lessons-list',
  templateUrl: './lessons-list.component.html',
  styleUrls: ['./lessons-list.component.css'],
})
export class LessonsListComponent extends BasicList<Lesson> implements OnInit {
  constructor(formBuilder: FormBuilder, lessonService: LessonsService) {
    super(
      formBuilder,
      lessonService,
      new SortableHeaders(
        ['Przedmiot', 'Temat', 'Od', 'Czas trwania', 'Opis', 'Uczniowie'],
        ['subject.name', 'topic', 'beginningDate', null, 'description', null],
        [15, 20, 10, 10, 25, 20]
      )
    );
  }

  getLessonLength(lesson: Lesson): number {
    if (lesson.endDate && lesson.beginningDate) {
      return (
        (new Date(lesson.endDate).getTime() -
          new Date(lesson.beginningDate).getTime()) /
        (1000 * 60 * 60) // milliseconds * seconds * minutes
      );
    }
    return 0;
  }

  ngOnInit(): void {
    this.init();
  }

  @HostListener('window:scroll', ['$event'])
  onScroll(event): void {
    this.loadNextIfPossible();
  }
}
