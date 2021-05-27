import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EducationPlan, EducationYear, Page, Student } from '../models/models';
import { environment } from '../../environments/environment';
import { BasicListService } from '../common/basic-list/basic-list';
import { AuthHttpClient } from '../common/auth-http-client.service';

@Injectable({
  providedIn: 'root',
})
export class StudentService implements BasicListService<Student> {
  private baseUrl = environment.BACKEND_URL + 'student';

  constructor(private http: AuthHttpClient) {}

  getAllBy(
    pageNumber: number,
    query: string,
    sort: string = null
  ): Observable<Page<Student>> {
    return this.http.get<Page<Student>>(
      this.baseUrl +
        '/all?page=' +
        pageNumber +
        (query ? '&query=' + query : '') +
        (sort ? '&sort=' + sort : '')
    );
  }

  getStudentsForLesson(lessonId: string): Observable<Student[]> {
    return this.http.get<Student[]>(this.baseUrl + '/forLesson/' + lessonId);
  }

  getStudentById(id: string): Observable<Student> {
    return this.http.get<Student>(this.baseUrl + '/' + id);
  }

  addStudent(student: Student): Observable<Student> {
    return this.http.post<Student>(this.baseUrl, student);
  }

  updateStudent(id: string, student: Student): Observable<Student> {
    return this.http.put<Student>(this.baseUrl + '/' + id, student);
  }

  getEducationYearsFor(studentId: string): Observable<EducationYear[]> {
    return this.http.get<EducationYear[]>(
      this.baseUrl + '/' + studentId + '/year'
    );
  }

  addEducationYear(educationYear: EducationYear): Observable<EducationYear> {
    return this.http.post<EducationYear>(this.baseUrl + '/year', educationYear);
  }

  getEducationPlansFor(yearId: string): Observable<EducationPlan[]> {
    return this.http.get<EducationPlan[]>(this.baseUrl + '/plan/' + yearId);
  }

  addEducationPlan(educationPlan: EducationPlan): Observable<EducationPlan> {
    return this.http.post<EducationPlan>(this.baseUrl + '/plan', educationPlan);
  }
}
