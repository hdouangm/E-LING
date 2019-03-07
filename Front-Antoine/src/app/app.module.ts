import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { InterventionComponent } from './intervention/intervention.component';
import { HttpClientModule } from '@angular/common/http';
import { ExamenComponent } from './examen/examen.component';
import { MatTableModule } from '@angular/material/table';
import { ReactiveFormsModule } from '@angular/forms';
import { ExamenDetailComponent } from './examen/examen-detail/examen-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    InterventionComponent,
    ExamenComponent,
    ExamenDetailComponent,
  ],
  imports: [
    ReactiveFormsModule,
    BrowserModule,
    HttpClientModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
