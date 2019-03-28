import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { DiagnostiqueService } from './diagnostique.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FileService } from 'src/app/file/file.service';
import { Diagnostique } from '../datamodel/data';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-diagnostique',
  templateUrl: './diagnostique.component.html',
  styleUrls: ['./diagnostique.component.css']
})
export class DiagnostiqueComponent implements OnInit {
    public diagnostique: Diagnostique;
    registerForm: FormGroup;
    submitted = false;
    id: any;

    @ViewChild('myModallDiagnostique') openModal: ElementRef;

  // tslint:disable-next-line:max-line-length
  constructor( private formBuilder: FormBuilder, public diagnostiqueService: DiagnostiqueService, public fileService: FileService, public route: ActivatedRoute) {
   }

  ngOnInit() {
      this.openModal.nativeElement.click();
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
        // tslint:disable-next-line:radix
        this.diagnostiqueService.linkDMP(res.id, Number.parseInt(this.route.snapshot.paramMap.get('id'))).subscribe(() => history.back());
        this.id = res.id;
     //   this.diagnostiqueService.linkResponsable(res.id, this.responsable).subscribe();
    } );

    }
    get f() { return this.registerForm.controls; }

    cancel() {
      history.back();
    }


}
