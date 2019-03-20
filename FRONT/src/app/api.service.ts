import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  API_URL = 'http://localhost:8080/Patient-1.0-SNAPSHOT/rs';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private  httpClient: HttpClient) {
  }

  setProf(dmp){
    return this.httpClient.post(`${this.API_URL}/DMP/profession/`, dmp, this.httpOptions);

  }
  createCompteAphp(compte) {
    return this.httpClient.post(`${this.API_URL}/CompteAphp/`, compte);
  }

  getCompteAphp() {
    return this.httpClient.get(`${this.API_URL}/CompteAphp`);
  }

  getCompteAphpAll(val1, val2) {
    return this.httpClient.get(`${this.API_URL}/CompteAphp/Search/` + val1 + `/` + val2);
  }

  createDemandeExamen(dExamen) {
    return this.httpClient.post(`${this.API_URL}/DemandeExamen/`, dExamen);
  }

  getNiveau(login) {
    return this.httpClient.post(`${this.API_URL}/Profil/getNiveau/`, login, this.httpOptions);

  }


  updateDemandeExamen(dExamen) {
    return  this.httpClient.put(`${this.API_URL}/DemandeExamen/Update/`, dExamen, this.httpOptions);
  }


  createDemandeIntervention(dIntervention) {
    return this.httpClient.post(`${this.API_URL}/DemandeIntervention/`, dIntervention);
  }


  updateDemandeIntervention(dIntervention) {
    return  this.httpClient.put(`${this.API_URL}/DemandeIntervention/Update/`, dIntervention, this.httpOptions);
  }





  getDonneesSociales(id: string) {
  return this.httpClient.post(`${this.API_URL}/Profil/getDonneesSociales/`, id, this.httpOptions);


}

// ok
  getDMP(id: string) {
    return this.httpClient.get(`${this.API_URL}/DMP/${id}`);
  }
  getDMPP(id: string) {
    return this.httpClient.post(`${this.API_URL}/DMP/getDMP/`, id, this.httpOptions);
  }
  getDMPS() {
    return this.httpClient.get(`${this.API_URL}/DMP`);
  }
  getPatient(id: string) {
    return this.httpClient.get(`${this.API_URL}/Patient/PatientByID?id=${id}`);


  }

  // ok
  getProfil(id: string) {
    return this.httpClient.get(`${this.API_URL}/Profil/${id}`);
  }
  getTypeExamen() {
    return  this.httpClient.get(`${this.API_URL}/TypeExamen`);
  }
  getTypeIntervention() {
    return  this.httpClient.get(`${this.API_URL}/TypeIntervention`);
  }

  modifierProfil(profil: object) {
    return this.httpClient.put(`${this.API_URL}/Profil/`, profil, this.httpOptions);
  }



  getDemandeExamenMed() {
    return  this.httpClient.get(`${this.API_URL}/DemandeExamen/Med`);
  }

  getDemandeExamenLab() {
    return  this.httpClient.get(`${this.API_URL}/DemandeExamen/Lab`);
  }

  public connexion(user: any)  {
    return this.httpClient.post(`${this.API_URL}/Connexion/`,
      user,
      {  responseType: 'text' as 'json' }
    );
  }




  public getEmployeConnecte() {
    const login = localStorage.getItem('user');
    return this.httpClient.get(`${this.API_URL}/Employe/getByLogin/${login}`);
  }





  public deconnexion() {
    localStorage.removeItem('ACCESS_TOKEN');
    localStorage.removeItem('nom');
    localStorage.removeItem('prenom');
  }

  // Tester si l'utilisateur est connecté pour le gard
  public isLoggedIn() {
    return localStorage.getItem('ACCESS_TOKEN') !== null;
  }











  getDemandeInterventionMed() {
    return  this.httpClient.get(`${this.API_URL}/DemandeIntervention/Med`);
  }

  getDemandeInterventionLab() {
    return  this.httpClient.get(`${this.API_URL}/DemandeIntervention/Lab`);
  }

  getDemandeInterventionId(val1) {
    return  this.httpClient.get(`${this.API_URL}/DemandeIntervention/Search/` + val1);
  }



  deleteDemandeIntervention(id) {
    // return  this.httpClient.put(`${this.API_URL}/DemandeIntervention/Delete/`+id, this.httpOptions);
  }

}
