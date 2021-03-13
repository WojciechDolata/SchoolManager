import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentsListComponent } from './students/students-list/students-list.component';
import { LessonsListComponent } from './lessons/lessons-list/lessons-list.component';
import { LessonDetailsComponent } from './lessons/lesson-details/lesson-details.component';
import { StudentDetailsComponent } from './students/student-details/student-details.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    StudentsListComponent,
    LessonsListComponent,
    LessonDetailsComponent,
    StudentDetailsComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
