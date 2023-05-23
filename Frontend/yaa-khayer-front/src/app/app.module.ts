import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HttpClientModule} from '@angular/common/http';
import { DonnationListComponent } from './components/donnation-list/donnation-list.component'
import { DonnationService } from './services/donnation.service';
import { SidebarnavComponent } from './components/sidebarnav/sidebarnav.component';
import { RouterModule, Routes } from '@angular/router';
import { DonnationDetailsComponent } from './components/donnation-details/donnation-details.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AddIndividuComponent } from './components/add-individu/add-individu.component';
import { AddAssociationComponent } from './components/add-association/add-association.component';

const routes: Routes = [
  { path: 'add-association', component: AddAssociationComponent },
  { path: 'add-individu', component: AddIndividuComponent },
  { path: 'register-form', component: RegisterComponent },
  { path: 'authenticate-form', component: LoginComponent },
  { path: 'donnations/:id', component: DonnationDetailsComponent },
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
    SidebarnavComponent,
    DonnationDetailsComponent,
    LoginComponent,
    RegisterComponent,
    AddIndividuComponent,
    AddAssociationComponent
  ],
  
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule
  ],

  providers: [DonnationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
