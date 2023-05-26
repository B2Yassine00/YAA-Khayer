import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Utilisateur } from '../entities/utilisateur';


const AUTH_API = 'http://localhost:8000/api/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.httpClient.post(AUTH_API + 'auth/authenticate', {
      username,
      password
    }, httpOptions);
  }

  register(username: string, email: string,role: string ,password: string): Observable<any> {
    return this.httpClient.post(AUTH_API + 'auth/signin', {
      username,
      email,
      role,
      password
    }, httpOptions);
  }
  addindiv(utilisateur: Utilisateur, nom:string,prenom:string,numero:string): Observable<any> {
    return this.httpClient.post(AUTH_API+"register/add-individu",{
      utilisateur,
      nom,
      prenom,
      numero
    }, httpOptions);
  }
}
