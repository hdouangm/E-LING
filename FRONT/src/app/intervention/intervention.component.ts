import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { InterventionService } from './intervention.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FileService } from 'src/app/file/file.service';
import { Intervention } from '../datamodel/data';
import { ActivatedRoute } from '@angular/router';


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

<<<<<<< HEAD
    @ViewChild('myModallInterventionn') openModal: ElementRef;
=======
    //@Input() dmp: number;
    //@Input() demande: number;
>>>>>>> branch 'master' of https://github.com/hdouangm/E-LING

<<<<<<< HEAD

  // tslint:disable-next-line:max-line-length
  constructor( private formBuilder: FormBuilder, public interventionService: InterventionService, public fileService: FileService, public route: ActivatedRoute) {
=======
    //@Input() responsable: number;
  constructor( private formBuilder: FormBuilder, public interventionService: InterventionService, public fileService: FileService,public route: ActivatedRoute) {
>>>>>>> branch 'master' of https://github.com/hdouangm/E-LING
   }

  ngOnInit() {
      this.openModal.nativeElement.click();
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
    console.log(this.route.snapshot.paramMap.get('id'));
    this.interventionService.createIntervention(this.intervention).subscribe((res) => {
        console.log(res.id);
        this.fileService.uploadFile(this.selectedFile, 'intervention' + res.id);
<<<<<<< HEAD
       // this.interventionService.linkDemande(res.id, this.demande).subscribe();
        // tslint:disable-next-line:radix
        this.interventionService.linkDMP(res.id, Number.parseInt(this.route.snapshot.paramMap.get('id'))).subscribe();
      //  this.interventionService.linkResponsable(res.id, this.responsable).subscribe();
=======
        //this.interventionService.linkDemande(res.id, this.demande).subscribe();
        this.interventionService.linkDMP(res.id, Number.parseInt(this.route.snapshot.paramMap.get('id'))).subscribe();
        //this.interventionService.linkResponsable(res.id, this.responsable).subscribe();
>>>>>>> branch 'master' of https://github.com/hdouangm/E-LING
    } );

    }


}

