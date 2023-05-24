import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DonnationCategory } from 'src/app/entities/donnation-category';
import { DonnationService } from 'src/app/services/donnation.service';

@Component({
  selector: 'app-sidebarnav',
  templateUrl: './sidebarnav.component.html',
  styleUrls: ['./sidebarnav.component.css']
})
export class SidebarnavComponent implements OnInit{
  
  constructor(private donnationService: DonnationService,
              private router: Router){  }

  showMenu = false;
  showSideBar = false;

  donnationCategories : DonnationCategory[] = []; 
  
  ngOnInit(): void {
    this.listDonnationCategories();
  }

  OnChange(){   
    this.showMenu = !this.showMenu;
  }

  OnSideChange(){
    this.showSideBar = !this.showSideBar;
  }
  
  listDonnationCategories() {
    this.donnationService.getDonnationCategories().subscribe(
      data=>{
        this.donnationCategories = data;
      }
    )  
  }

  doSearch(value: string){
    this.router.navigateByUrl(`/search/${value}`);
  }
}
