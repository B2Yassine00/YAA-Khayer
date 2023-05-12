import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Donnation } from '../entities/donnation';
import { Observable } from 'rxjs/internal/Observable';
import { map } from 'rxjs/internal/operators/map';

@Injectable({
  providedIn: 'root'
})
export class DonnationService {

  private baseUrl = 'http://localhost:8000/api/donnations';

  constructor(private httpClient: HttpClient) { }

  getDonnationList(): Observable<Donnation[]>{
    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
      map(
        response=>response._embedded.donnations));
  }
}

interface GetResponse{
  _embedded:{
    donnations:Donnation[]};
}