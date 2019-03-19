import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes), FormsModule,
    ReactiveFormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
