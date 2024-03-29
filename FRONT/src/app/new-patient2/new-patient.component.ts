import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { MustMatch} from './must-match.validator';
import { environment } from './../../environments/environment';
import { map } from 'rxjs/operators';


@Component({
  selector: 'app-new-patient2',
  templateUrl: './new-patient.component.html',
  styleUrls: ['./new-patient.component.css']
})
export class NewPatientDeuxComponent implements OnInit {
    restItems: any;
    restItemsUrl =  environment.apiUrl + '/medecin/medecins';
  @ViewChild('myModall') openModal: ElementRef;

  createPatientURL = environment.apiUrl + '/secretairemedicale/creerpatient';
    registerForm: FormGroup;
    submitted = false;

    constructor(private formBuilder: FormBuilder, private httpClient: HttpClient, private router: Router) {

    }

    ngOnInit() {
        this.getRestItems();

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
            medecinEnCharge: ['', Validators.required],
        }, {
            validator: MustMatch('ss', 'genre', 'age', 'pays')
        });
    }

    // convenience getter for easy access to form fields
    get f() { return this.registerForm.controls; }

    cancel(){
      location.replace("listePatient");
    }

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
        .set('genre', this.registerForm.value.genre)
        .set('medecinEnCharge', this.registerForm.value.medecinEnCharge);

        const req = this.httpClient.get(this.createPatientURL, {params})
          .subscribe(
            res => {
              console.log(res);
              alert('Le patient a été créé');
              location.replace("listePatient");




            },
            err => {
              alert('Le patient a déjà été créé');
              console.log('Error occured');
            }
          );
    }

    // Read all REST Items
    getRestItems(): void {
      this.restItemsServiceGetRestItems()
        .subscribe(
          restItems => {
            this.restItems = restItems;
            console.log(this.restItems);
          }
        );
    }

    // Rest Items Service: Read all REST Items
    restItemsServiceGetRestItems() {
      return this.httpClient
        .get<any[]>(this.restItemsUrl)
        .pipe(map(data => data));
    }

}
