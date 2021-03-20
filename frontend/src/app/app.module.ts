import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentsListComponent } from './students/students-list/students-list.component';
import { LessonsListComponent } from './lessons/lessons-list/lessons-list.component';
import { LessonDetailsComponent } from './lessons/lesson-details/lesson-details.component';
import { StudentDetailsComponent } from './students/student-details/student-details.component';
import { HttpClientModule } from '@angular/common/http';
import { AddStudentModalComponent } from './students/add-student/add-student-modal.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { EducationYearsComponent } from './students/education-years/education-years.component';
import { AddSchoolComponent } from './students/add-school/add-school.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentsListComponent,
    LessonsListComponent,
    LessonDetailsComponent,
    StudentDetailsComponent,
    AddStudentModalComponent,
    EducationYearsComponent,
    AddSchoolComponent,
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
