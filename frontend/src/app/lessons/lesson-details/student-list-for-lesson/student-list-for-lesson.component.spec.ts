import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentListForLessonComponent } from './student-list-for-lesson.component';

describe('StudentListForLessonComponent', () => {
  let component: StudentListForLessonComponent;
  let fixture: ComponentFixture<StudentListForLessonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [StudentListForLessonComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentListForLessonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
