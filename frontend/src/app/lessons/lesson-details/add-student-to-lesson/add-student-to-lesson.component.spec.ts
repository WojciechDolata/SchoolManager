import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddStudentToLessonComponent } from './add-student-to-lesson.component';

describe('AddStudentToLessonComponent', () => {
  let component: AddStudentToLessonComponent;
  let fixture: ComponentFixture<AddStudentToLessonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddStudentToLessonComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddStudentToLessonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
