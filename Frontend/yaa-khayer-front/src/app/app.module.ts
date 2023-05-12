import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HttpClientModule} from '@angular/common/http';
import { DonnationListComponent } from './components/donnation-list/donnation-list.component'
import { DonnationService } from './services/donnation.service';

@NgModule({
  declarations: [
    AppComponent,
    DonnationListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [DonnationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
