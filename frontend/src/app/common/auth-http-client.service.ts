import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AUTH_HEADER } from '../../environments/auth';

@Injectable({
  providedIn: 'root',
})
export class AuthHttpClient {
  constructor(private http: HttpClient) {}

  public get<T>(url: string): Observable<T> {
    return this.http.get<T>(url, {
      headers: AUTH_HEADER,
    });
  }

  public post<T>(url: string, data): Observable<T> {
    return this.http.post<T>(url, data, {
      headers: AUTH_HEADER,
    });
  }

  public put<T>(url: string, data): Observable<T> {
    return this.http.put<T>(url, data, {
      headers: AUTH_HEADER,
    });
  }

  public delete<T>(url: string): Observable<T> {
    return this.http.delete<T>(url, {
      headers: AUTH_HEADER,
    });
  }
}
