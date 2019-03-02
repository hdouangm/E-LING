import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FinderComponent } from './finder/finder.component';
import { ListPatientComponent } from './list-patient/list-patient.component';
import { HttpClientModule } from '@angular/common/http';
import { NewPatientComponent } from './new-patient/new-patient.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { DetailPatientComponent } from './detail-patient/detail-patient.component';
import { FileUploadComponent } from './file-upload/file-upload.component';
import { FileSelectDirective, FileUploader } from 'ng2-file-upload';
import { FileUploadModule } from "ng2-file-upload";
import {CustomMaterialModule} from "./file-upload/material.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {RouterModule} from "@angular/router";
import { FilterNamePipe } from './list-patient/filter-name.pipe';

@NgModule({
  declarations: [
    AppComponent,
    FinderComponent,
    ListPatientComponent,
    NewPatientComponent,
    DetailPatientComponent,
    FileUploadComponent,
    FilterNamePipe,
  ],
  imports: [
    ReactiveFormsModule,
    HttpClientModule,
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    FileUploadModule,
    CustomMaterialModule,
    RouterModule.forRoot([
      {path: '', component: FileUploadComponent}
    ]),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
