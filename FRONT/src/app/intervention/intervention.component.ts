import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { InterventionService } from './intervention.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FileService } from 'src/app/file/file.service';
import { Intervention } from '../datamodel/data';


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

    @Input() dmp: number;
    @Input() demande: number;

    @Input() responsable: number;
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
    this.intervention.urlResultats = this.selectedFile.name;
    this.intervention.publication = true ;
    const today: Date = new Date();
    const date: string = today.getDate() + '/' + (1 + today.getMonth()) + '/' + today.getFullYear();
    this.intervention.date = date;
    // this.intervention.demandeIntervention = this.demande;
    // this.intervention.responsable = this.user;
    // tslint:disable-next-line:max-line-length
    this.interventionService.createIntervention(this.intervention).subscribe((res:any) => {
        this.fileService.uploadFile(this.selectedFile, 'intervention' + res.id);
        this.interventionService.linkDemande(res.id, this.demande).subscribe();
        this.interventionService.linkDMP(res.id, this.dmp).subscribe();
        this.interventionService.linkResponsable(res.id, this.responsable).subscribe();
    } );

    }


}
