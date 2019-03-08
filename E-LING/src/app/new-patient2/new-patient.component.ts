import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { MustMatch} from './must-match.validator';


@Component({
  selector: 'app-new-patient2',
  templateUrl: './new-patient.component.html',
  styleUrls: ['./new-patient.component.css']
})
export class NewPatientDeuxComponent implements OnInit {
  @ViewChild('myModall') openModal: ElementRef;

  createPatientURL = 'http://localhost:8080/Patient-1.0-SNAPSHOT/rs/secretairemedicale/creerpatient';
    registerForm: FormGroup;
    submitted = false;

    constructor(private formBuilder: FormBuilder, private httpClient: HttpClient, private router: Router) {

    }

    ngOnInit() {


      this.openModal.nativeElement.click();

      this.registerForm = this.formBuilder.group({
            ss: ['', Validators.required],
            nom: ['', Validators.required],
            prenom: ['', Validators.required],
            adresse: ['', Validators.required],
            ville: ['', Validators.required],
            codePostal: ['', Validators.required],
            pays: ['', Validators.required],
            age: ['', Validators.required],
            email: ['', [Validators.required, Validators.email]],
            genre: ['', Validators.required],
        }, {
            validator: MustMatch('ss', 'genre', 'age', 'pays')
        });
    }

    // convenience getter for easy access to form fields
    get f() { return this.registerForm.controls; }



    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.registerForm.invalid) {
            return;
        }

        const params = new HttpParams()
        .set('ss', this.registerForm.value.ss)
        .set('nom', this.registerForm.value.nom)
        .set('prenom', this.registerForm.value.prenom)
        .set('adresse', this.registerForm.value.adresse)
        .set('ville', this.registerForm.value.ville)
        .set('codePostal', this.registerForm.value.codePostal)
        .set('pays', this.registerForm.value.pays)
        .set('age', this.registerForm.value.age)
        .set('genre', this.registerForm.value.genre);

        const req = this.httpClient.get(this.createPatientURL, {params})
          .subscribe(
            res => {
              console.log(res);
              alert('Le patient a été créé');
              location.reload();
              this.router.navigate(['listePatient']);



            },
            err => {
              alert('Le patient a déjà été créé');
              console.log('Error occured');
            }
          );
    }

}
