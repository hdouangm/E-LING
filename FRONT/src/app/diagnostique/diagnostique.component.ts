import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { DiagnostiqueService } from './diagnostique.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FileService } from 'src/app/file/file.service';
import { Diagnostique } from '../datamodel/data';


@Component({
  selector: 'app-diagnostique',
  templateUrl: './diagnostique.component.html',
  styleUrls: ['./diagnostique.component.css']
})
export class DiagnostiqueComponent implements OnInit {
    selectedFile: File;
    public diagnostique: Diagnostique;
    registerForm: FormGroup;
    submitted = false;

    @Input() dmp: number;

    @Input() responsable: number;
  constructor( private formBuilder: FormBuilder, public diagnostiqueService: DiagnostiqueService, public fileService: FileService) {
   }

  ngOnInit() {
      this.registerForm = this.formBuilder.group({
        datedebut: ['', Validators.required],
        datefin: ['', Validators.required],
        diagnostique: ['', Validators.required]});
  }

  onSubmit() {
    this.diagnostique = new Diagnostique();
    this.diagnostique.diagnostic = this.registerForm.value.diagnostique;
    this.submitted = true;
    this.diagnostique.publication = true ;
    const today: Date = new Date();
    const date: string = today.getDate() + '/' + (1 + today.getMonth()) + '/' + today.getFullYear();
    this.diagnostique.date = date;
    // this.diagnostique.demandeDiagnostique = this.demande;
    // this.diagnostique.responsable = this.user;
    // tslint:disable-next-line:max-line-length
    this.diagnostiqueService.createDiagnostique(this.diagnostique).subscribe((res) => {
        this.fileService.uploadFile(this.selectedFile, 'diagnostique' + res.id);
        this.diagnostiqueService.linkDMP(res.id, this.dmp).subscribe();
        this.diagnostiqueService.linkResponsable(res.id, this.responsable).subscribe();
    } );

    }
    get f() { return this.registerForm.controls; }


}
