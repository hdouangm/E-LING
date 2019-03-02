import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListPatientComponent } from './list-patient/list-patient.component'
import { NewPatientComponent } from './new-patient/new-patient.component'
import { DetailPatientComponent } from './detail-patient/detail-patient.component'
import { FileUploadComponent } from './file-upload/file-upload.component'

const routes: Routes = [
    {path: 'secretaire/patients', component: ListPatientComponent},
    {path: 'secretaire/new-patient', component: NewPatientComponent},
    {path: 'secretaire/patient', component: DetailPatientComponent},
    {path: 'upload', component: FileUploadComponent},

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
