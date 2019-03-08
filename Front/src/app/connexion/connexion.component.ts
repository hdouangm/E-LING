import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from 'src/app/api.service';
import { Router } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})

export class ConnexionComponent implements OnInit {
  loginForm: FormGroup;
  submitted = false;
  messageErreur: string;
  connexion: boolean;
  httpClient: HttpClient;

  constructor(private fb: FormBuilder, private  apiService:  ApiService, private router: Router ) {}

  ngOnInit() {
   this.loginForm = this.fb.group({
      login: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
    this.messageErreur = '';

     // reset login status
        this.apiService.deconnexion();
}

 // convenience getter for easy access to form fields
 get f() { return this.loginForm.controls; }

 onSubmit() {
     this.submitted = true;
     // stop here if form is invalid
     if (this.loginForm.invalid) {
       return;
     }

     const data = {
       'username' : this.getValue('login'),
       'password' : this.getValue('password')
     };

    this.apiService.connexion(data)
      .subscribe((reponse:  any) => {
        console.log('reponse: ' + JSON.stringify(reponse));
        if (reponse == null) {
          this.messageErreur = `Erreur d'authentification`;
          return;
        }
         localStorage.setItem('ACCESS_TOKEN', reponse);
         localStorage.setItem('user', data.username);
        this.router.navigate(['accederDMP/308']);
    },
    error => {
      alert(`Oups une erreur s'est produite.`);
      this.router.navigate(['connexion']);
    });

}

getValue(id: string) {
  return this.loginForm.get(`${id}`).value;
}


}



