import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { PosologieService } from './posologie.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FileService } from 'src/app/file/file.service';
import { Posologie } from '../datamodel/data';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-posologie',
  templateUrl: './posologie.component.html',
  styleUrls: ['./posologie.component.css']
})
export class PosologieComponent implements OnInit {
    public posologie: Posologie;
    registerForm: FormGroup;
    submitted = false;
    id: any;

    @ViewChild('myModallPosologie') openModal: ElementRef;

  // tslint:disable-next-line:max-line-length
  constructor( private formBuilder: FormBuilder, public posologieService: PosologieService, public fileService: FileService, public route: ActivatedRoute) {
   }

  ngOnInit() {
      this.openModal.nativeElement.click();
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
    const today: Date = new Date();
    const date: string = today.getDate() + '/' + (1 + today.getMonth()) + '/' + today.getFullYear();
    this.posologie.dateDebut = this.registerForm.value.datedebut;
    this.posologie.dateFin = this.registerForm.value.datefin;
    // this.posologie.demandePosologie = this.demande;
    // this.posologie.responsable = this.user;
    // tslint:disable-next-line:max-line-length
    this.posologieService.createPosologie(this.posologie).subscribe((res) => {
        // tslint:disable-next-line:radix
        this.posologieService.linkDMP(res.id, Number.parseInt(this.route.snapshot.paramMap.get('id'))).subscribe(() => history.back());
        this.id = res.id;
     //   this.posologieService.linkResponsable(res.id, this.responsable).subscribe();
        this.cancel();
    } );

    }
    get f() { return this.registerForm.controls; }

    cancel() {
            history.back();
    }


}
