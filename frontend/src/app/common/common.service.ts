import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { School, Subject } from '../models/models';
import { AuthHttpClient } from './auth-http-client.service';

@Injectable({
  providedIn: 'root',
})
export class CommonService {
  private baseUrl = environment.BACKEND_URL + 'common';

  constructor(private http: AuthHttpClient) {}

  addSchool(school: School): Observable<School> {
    return this.http.post<School>(this.baseUrl + '/school', school);
  }

  getAllSchools(): Observable<School[]> {
    return this.http.get<School[]>(this.baseUrl + '/school');
  }

  addSubject(subject: Subject): Observable<Subject> {
    return this.http.post<Subject>(this.baseUrl + '/subject', subject);
  }

  getAllSubjects(): Observable<Subject[]> {
    return this.http.get<Subject[]>(this.baseUrl + '/subject');
  }
}
