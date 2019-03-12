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
       adresse: ['', [Validators.required]]
     });
 }

 getProfil(): void {
  this.id = this.activateRoute.snapshot.paramMap.get('id');
  this.apiService.getProfil(`${this.id}`)
    .subscribe((reponse: object) => {
      console.log(reponse);
      this.profil = reponse;
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
    id : this.id,
      nom : this.getValue('nom'),
      prenom : this.getValue('prenom'),
      adresse : this.getValue('adresse')
    };

    this.apiService.modifierProfil(data)
       .subscribe((reponse: object) => {
         console.log(reponse);
         return;
         this.router.navigate([`modifierProfil/${this.id}`]);
     });
 }

getValue(id: string) {
   return this.form.get(`${id}`).value;
 }

}
