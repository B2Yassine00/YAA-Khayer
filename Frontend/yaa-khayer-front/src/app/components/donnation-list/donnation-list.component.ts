import { Component, OnInit } from '@angular/core';
import { Donnation } from 'src/app/entities/donnation';
import { DonnationService } from 'src/app/services/donnation.service';

@Component({
  selector: 'app-donnation-list',
  templateUrl: './donnation-list.component.html',
  styleUrls: ['./donnation-list.component.css']
})
export class DonnationListComponent implements OnInit{

  donnations: Donnation[] = [];
  constructor(private donnationService: DonnationService){}

  ngOnInit(): void {
    this.listDonnations();
  }

  listDonnations(){
    this.donnationService.getDonnationList().subscribe(
      data =>{
        this.donnations = data;
      }
    );
  }
}
