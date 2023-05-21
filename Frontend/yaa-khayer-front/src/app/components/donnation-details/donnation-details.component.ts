import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Donnation } from 'src/app/entities/donnation';
import { DonnationService } from 'src/app/services/donnation.service';

@Component({
  selector: 'app-donnation-details',
  templateUrl: './donnation-details.component.html',
  styleUrls: ['./donnation-details.component.css']
})
export class DonnationDetailsComponent implements OnInit {
  
  donnation!: Donnation;

  constructor(private donnationService: DonnationService,
              private router: ActivatedRoute){

  }

  ngOnInit(): void {
    this.router.paramMap.subscribe(()=>{
      this.handleDonnationDetails();
    })
  }
  handleDonnationDetails() {

    const DonnId: number = +this.router.snapshot.paramMap.get('id')!;

    this.donnationService.getDonnation(DonnId).subscribe(
      data =>{
        this.donnation = data;
      }
    )
  }

}
