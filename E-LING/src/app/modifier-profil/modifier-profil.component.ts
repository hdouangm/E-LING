import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from 'src/app/api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-modifier-profil',
  templateUrl: './modifier-profil.component.html',
  styleUrls: ['./modifier-profil.component.css']
})
export class ModifierProfilComponent implements OnInit {
  form: FormGroup;
  submitted = false;
  id: string;
  profil: any;

  constructor(private fb: FormBuilder, private  apiService: ApiService, private router: Router, private activateRoute: ActivatedRoute ) {}


ngOnInit() {
  this.getProfil();
  this.form = this.fb.group({
       nom: ['', [Validators.required]],
       prenom: ['' , [Validators.required]],
       adresse: ['', [Validators.required]],
       age: ['', [Validators.required]],
       codePostal: ['', [Validators.required]],
       //genre: ['', [Validators.required]],
       pays: ['', [Validators.required]],
       ville: ['', [Validators.required]]
     });
 }

 getProfil(): void {

  const user = localStorage.getItem('user');
  this.apiService.getDonneesSociales(user).subscribe((response: any) => {
    if (response == null) {
      return;
    }
    console.log(JSON.stringify(response));
    this.profil = response;
    });
}

// convenience getter for easy access to form fields
get f() { return this.form.controls; }

onSubmit() {
    this.submitted = true;
      // stop here if form is invalid
    if (this.form.invalid) {
        return;
      }

    const data = {
      id : this.profil.id,
      nom : this.getValue('nom'),
      prenom : this.getValue('prenom'),
      adressse : this.getValue('adresse'),
      age: this.getValue('age'),
      codePostal: this.getValue('codePostal'),
      genre: this.profil.genre,
      pays: this.getValue('pays'),
      ville: this.getValue('ville')
    };
    console.log('data : ', JSON.stringify(data));
    this.apiService.modifierProfil(data)
       .subscribe((reponse: object) => {
         console.log(reponse);
         this.router.navigate(['listePatient']);
     },
     error => {
      alert(`Oups une erreur s'est produite.`);
     // this.router.navigate(['connexion']);
    });
 }

getValue(id: string) {
   return this.form.get(`${id}`).value;
 }

}
