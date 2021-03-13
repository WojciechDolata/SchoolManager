import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentsListComponent} from './students/students-list/students-list.component';
import {LessonsListComponent} from './lessons/lessons-list/lessons-list.component';

const routes: Routes = [
  { path: 'students', component: StudentsListComponent },
  { path: 'lessons', component: LessonsListComponent },
  { path: '**', component: LessonsListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
