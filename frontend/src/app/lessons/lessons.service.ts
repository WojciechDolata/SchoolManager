import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Lesson, Page } from '../models/models';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { BasicListService } from '../common/basic-list/basic-list';

@Injectable({
  providedIn: 'root',
})
export class LessonsService implements BasicListService<Lesson> {
  private baseUrl = environment.BACKEND_URL + 'lesson';

  constructor(private http: HttpClient) {}

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
}
