import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { Examen } from '../datamodel/examen';
import { ExamenService } from './examen.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FileService } from 'src/app/file/file.service';
import { Employe } from 'src/app/datamodel/Employe';
import { DemandeExamen } from 'src/app/datamodel/Demande_examen';

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

    @Input() user: Employe;
    @Input() demande: DemandeExamen;
  constructor( private formBuilder: FormBuilder, public examenService: ExamenService, public fileService: FileService) {
   }

  ngOnInit() {
      this.registerForm = this.formBuilder.group({
        file: ['', Validators.required]});
  }

  onFileSelected(event) {
     this.selectedFile = event.target.files[0] as File;
  }

  onSubmit() {
    this.examen = new Examen();
    this.submitted = true;
    this.examen.urlresultats = this.selectedFile.name;
    this.examen.publication = true ;
    const today: Date = new Date();
    const date: string = today.getDate() + '/' + (1 + today.getMonth()) + '/' + today.getFullYear();
    this.examen.date = date;
    this.examen.demandeExamen = this.demande;
    this.examen.responsable = this.user;
    // tslint:disable-next-line:max-line-length
    this.examenService.createExamen(this.examen).subscribe((res) => { this.fileService.uploadFile(this.selectedFile, 'examen' + res.id); } );
    console.log(this.examen.id);
   /* let blob: Blob;
    this.fileService.downloadFile('Examen0', 'arborescence.png').subscribe(res => {blob = res ; console.log(res.size); });
    this.createImageFromBlob(blob);*/
    // tslint:disable-next-line:prefer-const
      //  this.fileService.downloadFile('examen0', 'arborescence.png').subscribe(res => {console.log(res); });


    }


}





