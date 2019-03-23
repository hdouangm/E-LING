import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { PosologieService } from './posologie.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FileService } from 'src/app/file/file.service';
import { Posologie } from '../datamodel/data';


@Component({
  selector: 'app-posologie',
  templateUrl: './posologie.component.html',
  styleUrls: ['./posologie.component.css']
})
export class PosologieComponent implements OnInit {
    selectedFile: File;
    public posologie: Posologie;
    registerForm: FormGroup;
    submitted = false;

    @Input() dmp: number;

    @Input() responsable: number;
  constructor( private formBuilder: FormBuilder, public posologieService: PosologieService, public fileService: FileService) {
   }

  ngOnInit() {
      this.registerForm = this.formBuilder.group({
        datedebut: ['', Validators.required],
        datefin: ['', Validators.required],
        posologie: ['', Validators.required]});
  }


  onSubmit() {
    this.posologie = new Posologie();
    this.posologie.posologie = this.registerForm.value.posologie;
    this.submitted = true;
    this.posologie.publication = true ;
    this.posologie.dateDebut = this.registerForm.value.datedebut;
    this.posologie.dateFin = this.registerForm.value.datefin;
    // this.posologie.demandePosologie = this.demande;
    // this.posologie.responsable = this.user;
    // tslint:disable-next-line:max-line-length
    this.posologieService.createPosologie(this.posologie).subscribe((res) => {
        this.fileService.uploadFile(this.selectedFile, 'posologie' + res.id);
        this.posologieService.linkDMP(res.id, this.dmp).subscribe();
        this.posologieService.linkResponsable(res.id, this.responsable).subscribe();
    } );

    }
    get f() { return this.registerForm.controls; }


}
