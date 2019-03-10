import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { Intervention } from '../datamodel/intervention';
import { InterventionService } from './intervention.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FileService } from 'src/app/file/file.service';
import { Employe } from 'src/app/datamodel/Employe';
import { DemandeIntervention } from 'src/app/datamodel/Demande_intervention';

@Component({
  selector: 'app-intervention',
  templateUrl: './intervention.component.html',
  styleUrls: ['./intervention.component.css']
})
export class InterventionComponent implements OnInit {
    selectedFile: File;
    public intervention: Intervention;
    registerForm: FormGroup;
    submitted = false;

    @Input() user: Employe;
    @Input() demande: DemandeIntervention;
  constructor( private formBuilder: FormBuilder, public interventionService: InterventionService, public fileService: FileService) {
   }

  ngOnInit() {
      this.registerForm = this.formBuilder.group({
        file: ['', Validators.required]});
  }

  onFileSelected(event) {
     this.selectedFile = event.target.files[0] as File;
  }

  onSubmit() {
    this.intervention = new Intervention();
    this.submitted = true;
    this.intervention.URLresultats = this.selectedFile.name;
    this.intervention.publication = true ;
    const today: Date = new Date();
    const date: string = today.getDate() + '/' + (1 + today.getMonth()) + '/' + today.getFullYear();
    console.log(date);
    this.intervention.date = date;
    this.intervention.demandeIntervention = this.demande;
    this.intervention.responsable = this.user;
    // tslint:disable-next-line:max-line-length
    this.interventionService.createIntervention(this.intervention).subscribe(res => this.fileService.uploadFile(this.selectedFile, 'intervention' + res.id));

    }


}





