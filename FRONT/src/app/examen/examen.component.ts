import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { ExamenService } from './examen.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FileService } from 'src/app/file/file.service';
import { Examen } from '../datamodel/data';


@Component({
  selector: 'app-examen',
  templateUrl: './examen.component.html',
  styleUrls: ['./examen.component.css']
})
export class ExamenComponent implements OnInit {
    selectedFile: File;
    public examen: Examen;
    registerForm: FormGroup;
    submitted = false;

    @ViewChild('myModallExamenn') openModal: ElementRef;


  constructor( private formBuilder: FormBuilder, public examenService: ExamenService, public fileService: FileService) {
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
    this.examen = new Examen();
    this.submitted = true;
    this.examen.urlResultats = this.selectedFile.name;
    this.examen.publication = true ;
    const today: Date = new Date();
    const date: string = today.getDate() + '/' + (1 + today.getMonth()) + '/' + today.getFullYear();
    this.examen.date = date;
    // this.examen.demandeExamen = this.demande;
    // this.examen.responsable = this.user;
    // tslint:disable-next-line:max-line-length
    this.examenService.createExamen(this.examen).subscribe((res) => {
        this.fileService.uploadFile(this.selectedFile, 'examen' + res.id);
       // this.examenService.linkDemande(res.id, this.demande).subscribe();
      //  this.examenService.linkDMP(res.id, this.dmp).subscribe();
      //  this.examenService.linkResponsable(res.id, this.responsable).subscribe();
    } );

    }


}
