import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HttpClientModule} from '@angular/common/http';
import { DonnationListComponent } from './components/donnation-list/donnation-list.component'
import { DonnationService } from './services/donnation.service';
import { SidebarnavComponent } from './components/sidebarnav/sidebarnav.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'search/:keyword', component: DonnationListComponent },
  {path : 'category/:id', component: DonnationListComponent },
  {path : 'category/', component: DonnationListComponent },
  {path : 'donnations', component: DonnationListComponent },
  {path : '',redirectTo: '/donnations', pathMatch: 'full' },
  {path : '**', redirectTo: '/donnations', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    DonnationListComponent,
    SidebarnavComponent
  ],
  
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule
  ],

  providers: [DonnationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
