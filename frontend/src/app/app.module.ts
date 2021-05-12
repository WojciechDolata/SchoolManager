import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentsListComponent } from './students/students-list/students-list.component';
import { LessonsListComponent } from './lessons/lessons-list/lessons-list.component';
import { LessonDetailsComponent } from './lessons/lesson-details/lesson-details.component';
import { StudentDetailsComponent } from './students/student-details/student-details.component';
import { HttpClientModule } from '@angular/common/http';
import { AddStudentComponent } from './modals/add-student/add-student.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { EducationYearsComponent } from './students/education-years/education-years.component';
import { AddSchoolComponent } from './modals/add-school/add-school.component';
import { EducationPlansComponent } from './students/education-years/education-plans/education-plans.component';
import { AddSubjectComponent } from './modals/add-subject/add-subject.component';
import { StudentListForLessonComponent } from './lessons/lesson-details/student-list-for-lesson/student-list-for-lesson.component';
import { AddStudentToLessonComponent } from './lessons/lesson-details/add-student-to-lesson/add-student-to-lesson.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentsListComponent,
    LessonsListComponent,
    LessonDetailsComponent,
    StudentDetailsComponent,
    AddStudentComponent,
    EducationYearsComponent,
    AddSchoolComponent,
    EducationPlansComponent,
    AddSubjectComponent,
    StudentListForLessonComponent,
    AddStudentToLessonComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    MatProgressSpinnerModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
