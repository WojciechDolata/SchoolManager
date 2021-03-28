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
        ['Przedmiot', 'Temat', 'Od', 'Do', 'Opis', 'Uczniowie'],
        [
          'subject.name',
          'topic',
          'beginningDate',
          'endDate',
          'description',
          null,
        ],
        [15, 20, 10, 10, 25, 20]
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
