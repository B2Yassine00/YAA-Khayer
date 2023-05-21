import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';


const AUTH_API = 'http://localhost:8000/api/auth/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.httpClient.post(AUTH_API + 'authenticate', {
      username,
      password
    }, httpOptions);
  }

  register(username: string, email: string,role: string ,password: string): Observable<any> {
    return this.httpClient.post(AUTH_API + 'signin', {
      username,
      email,
      role,
      password
    }, httpOptions);
  }
}
