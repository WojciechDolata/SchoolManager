import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EducationPlan, EducationYear, Student } from '../models/models';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  private baseUrl = environment.BACKEND_URL + 'student';

  constructor(private http: HttpClient) {}

  getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.baseUrl + '/all');
  }

  getStudentById(id: string): Observable<Student> {
    return this.http.get<Student>(this.baseUrl + '/' + id);
  }

  addStudent(student: Student): Observable<Student> {
    return this.http.post<Student>(this.baseUrl, student);
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
