import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FinderComponent } from './finder/finder.component';
import { ListPatientComponent } from './list-patient/list-patient.component';
import { HttpClientModule } from '@angular/common/http';
import { NewPatientComponent } from './new-patient/new-patient.component';
import { ReactiveFormsModule } from '@angular/forms';
import { DetailPatientComponent } from './detail-patient/detail-patient.component';

@NgModule({
  declarations: [
    AppComponent,
    FinderComponent,
    ListPatientComponent,
    NewPatientComponent,
    DetailPatientComponent
  ],
  imports: [
    ReactiveFormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
