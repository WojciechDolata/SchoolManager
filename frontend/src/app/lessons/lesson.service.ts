import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Lesson, Page } from '../models/models';
import { environment } from '../../environments/environment';
import { BasicListService } from '../common/basic-list/basic-list';
import { AuthHttpClient } from '../common/auth-http-client.service';

@Injectable({
  providedIn: 'root',
})
export class LessonService implements BasicListService<Lesson> {
  private baseUrl = environment.BACKEND_URL + 'lesson';

  constructor(private http: AuthHttpClient) {}

  getAllBy(
    pageNumber: number,
    query: string,
    sort: string
  ): Observable<Page<Lesson>> {
    return this.http.get<Page<Lesson>>(
      this.baseUrl +
        '?page=' +
        pageNumber +
        (query ? '&query=' + query : '') +
        (sort ? '&sort=' + sort : '')
    );
  }

  getLessonById(id: string): Observable<Lesson> {
    return this.http.get<Lesson>(this.baseUrl + '/' + id);
  }

  addLesson(lesson: Lesson): Observable<Lesson> {
    return this.http.post<Lesson>(this.baseUrl, lesson);
  }

  updateLesson(id: string, lesson: Lesson): Observable<Lesson> {
    return this.http.put<Lesson>(this.baseUrl + '/' + id, lesson);
  }

  addStudentToLesson(lessonId: string, studentId: string): Observable<Lesson> {
    return this.http.put<Lesson>(
      this.baseUrl + '/' + lessonId + '/addStudent',
      studentId
    );
  }
}
