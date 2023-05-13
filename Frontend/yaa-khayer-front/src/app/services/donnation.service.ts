import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Donnation } from '../entities/donnation';
import { Observable } from 'rxjs/internal/Observable';
import { map } from 'rxjs/internal/operators/map';
import { DonnationCategory } from '../entities/donnation-category';

@Injectable({
  providedIn: 'root'
})
export class DonnationService {
  
  private baseUrl = 'http://localhost:8000/api/donnations';

  private categoryUrl = 'http://localhost:8000/api/donnation-category';

  constructor(private httpClient: HttpClient) { }

  getDonnationList(theCategoryId:number): Observable<Donnation[]>{

    if(theCategoryId===0){
      return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
        map(
          response=>response._embedded.donnations));
    }else{
      const searchUrl =`${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`;
      return this.getDonnations(searchUrl);
    }
    
  }
  getDonnationCategories() : Observable<DonnationCategory[]>{
    return this.httpClient.get<GetResponseDonnationCategory>(this.categoryUrl).pipe(
      map(
        response=>response._embedded.donnationCategory));
  }

  searchDonnations(theKeyword: string): Observable<Donnation[]> {
    const searchUrl = `${this.baseUrl}/search/findByNameContaining?name=${theKeyword}`!;
    return this.getDonnations(searchUrl);
  }


  private getDonnations(searchUrl: string): Observable<Donnation[]> {
    return this.httpClient.get<GetResponse>(searchUrl).pipe(
      map(
        response => response._embedded.donnations));
  }
}

interface GetResponse{
  _embedded:{
    donnations:Donnation[]};
}

interface GetResponseDonnationCategory{
  _embedded:{
    donnationCategory:DonnationCategory[]};
}