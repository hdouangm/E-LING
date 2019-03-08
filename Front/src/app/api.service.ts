import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  API_URL  = 'http://localhost:8080/Composants1-1.0/rs';

   public employe: any;

   httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private httpClient:  HttpClient) {}


  public connexion(user: any)  {
    return this.httpClient.post(`${this.API_URL}/Connexion/`,
     user,
     {  responseType: 'text' as 'json' }
     );
  }


  private getEmploye(objet: any) {
    return objet;
  }

  /*public getEmploye() {
    this.getEmployeConnecte();
    console.log('data2 : ' + JSON.stringify(this.employe));
    return this.employe;
  }*/

  // Methode à revoir
  public getEmployeConnecte() {
    let employe: any;
     const login = localStorage.getItem('user');
     this.httpClient.get(`${this.API_URL}/Employe/getByLogin/${login}`)
     .subscribe(
       (reponse:  any) => {
      console.log('getEmploye', JSON.stringify(reponse));
      localStorage.setItem('employe', JSON.stringify(reponse));
     employe = reponse;
      localStorage.setItem('niveau', reponse.donneesSociales.id);
  },
  error => {
    // console.log('Error getEmploye : ', JSON.stringify(error));
  });
    return localStorage.getItem('employe');
  }


  public getDMP(id: string) {
      return this.httpClient.get(`${this.API_URL}/DMP/${id}`);
    }


  public getProfil(id: string) {
      return this.httpClient.get(`${this.API_URL}/Profil/${id}`);
    }

  public modifierProfil(profil: object) {
    return this.httpClient.put(`${this.API_URL}/Profil/`, profil, this.httpOptions);
  }


  public deconnexion() {
     localStorage.clear();
    }

  // Tester si l'utilisateur est connecté pour le gard
  public isLoggedIn() {
    return localStorage.getItem('ACCESS_TOKEN') !== null;
  }



}
