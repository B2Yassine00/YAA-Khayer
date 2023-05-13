import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Donnation } from 'src/app/entities/donnation';
import { DonnationService } from 'src/app/services/donnation.service';

@Component({
  selector: 'app-donnation-list',
  templateUrl: './donnation-list.component.html',
  styleUrls: ['./donnation-list.component.css']
})
export class DonnationListComponent implements OnInit{

  currentCategoryId: number = 0 ;

  donnations: Donnation[] = [];

  searchMode: boolean=false;
  constructor(private donnationService: DonnationService,
              private route: ActivatedRoute){}

  ngOnInit(): void {
    this.route.paramMap.subscribe(
      () => {
              this.listDonnations()
            });
  }

  listDonnations(){
    
    this.searchMode = this.route.snapshot.paramMap.has('keyword');

    if(this.searchMode){
      const theKeyword: string = this.route.snapshot.paramMap.get('keyword')!;
      
      this.donnationService.searchDonnations(theKeyword).subscribe(
        data => {
          this.donnations = data;
        }
      )
      this.searchMode=false;
    }
    else{
      this.handleListDonnations();
    }
  }

  handleListDonnations(){
    //verifier si "id" est existant
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');
    if(hasCategoryId){

      //get the id param
      this.currentCategoryId=+this.route.snapshot.paramMap.get('id')!;
    }else{
      this.currentCategoryId = 0;
    }
     
    this.donnationService.getDonnationList(this.currentCategoryId).subscribe(
      data =>{
        this.donnations = data;
      }
    );
  }
}
