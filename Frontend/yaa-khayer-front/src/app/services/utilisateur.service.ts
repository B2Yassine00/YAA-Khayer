import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { TokenStorageService } from './token-storage.service';

const API_URL = "http://localhost:8000/demo/hello";


@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  constructor(private httpClient: HttpClient,
              private tokenStorage: TokenStorageService) { }

  httpOptions = {
                headers: new HttpHeaders({'Content-Type': 'application/text', 'Authorization': 'Bearer '+ this.tokenStorage.getToken()})
              };

  getPublicContent(): Observable<any> {
    console.log(this.tokenStorage.getToken());
    console.log(this.tokenStorage.getUser());

    return this.httpClient.get(API_URL,this.httpOptions);
  }
}
