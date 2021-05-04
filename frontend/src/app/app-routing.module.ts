import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentsListComponent } from './students/students-list/students-list.component';
import { LessonsListComponent } from './lessons/lessons-list/lessons-list.component';
import { StudentDetailsComponent } from './students/student-details/student-details.component';
import { LessonDetailsComponent } from './lessons/lesson-details/lesson-details.component';

const routes: Routes = [
  { path: 'students', component: StudentsListComponent },
  { path: 'student/:id/details', component: StudentDetailsComponent },
  { path: 'lesson/list', component: LessonsListComponent },
  { path: 'lesson', component: LessonDetailsComponent },
  { path: '**', component: LessonsListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
