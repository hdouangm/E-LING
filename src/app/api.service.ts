import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
    API_URL  = 'http://localhost:8080/OphelieComposants-1/rs';

    httpOptions = {
        headers : new HttpHeaders({'content-Type' : 'application/json'})
    };

    constructor(private  httpClient:  HttpClient) {}
    
    createCompteAphp(compte) {
        return  this.httpClient.post(`${this.API_URL}/CompteAphp/`, compte);
    }
    
    getCompteAphp() {
        return  this.httpClient.get(`${this.API_URL}/CompteAphp`);
    }

    getCompteAphpAll(val1,val2) {
        return  this.httpClient.get(`${this.API_URL}/CompteAphp/Search/`+val1+`/`+val2);
    }

    createDemandeExamen(dExamen) {
        return  this.httpClient.post(`${this.API_URL}/DemandeExamen/`, dExamen);
    }

    getDemandeExamen() {
        return  this.httpClient.get(`${this.API_URL}/DemandeExamen`);
    }

    getTypeExamen() {
        return  this.httpClient.get(`${this.API_URL}/TypeExamen`);
    }

    getDemandeExamenMed() {
        return  this.httpClient.get(`${this.API_URL}/DemandeExamen/Med`);
    }

    getDemandeExamenLab() {
        return  this.httpClient.get(`${this.API_URL}/DemandeExamen/Lab`);
    }

    getDemandeExamenId(val1) {
        return  this.httpClient.get(`${this.API_URL}/DemandeExamen/Search/`+val1);
    }

    updateDemandeExamen(dExamen) {
        return  this.httpClient.put(`${this.API_URL}/DemandeExamen/Update/`, dExamen, this.httpOptions);
    }

    deleteDemandeExamen(id) {
        return  this.httpClient.delete(`${this.API_URL}/DemandeExamen/Delete/`+id, this.httpOptions);
    }

    createDemandeIntervention(dIntervention) {
        return  this.httpClient.post(`${this.API_URL}/DemandeIntervention/`, dIntervention);
    }

    getDemandeIntervention() {
        return  this.httpClient.get(`${this.API_URL}/DemandeIntervention`);
    }

    getTypeIntervention() {
        return  this.httpClient.get(`${this.API_URL}/TypeIntervention`);
    }

    getDemandeInterventionMed() {
        return  this.httpClient.get(`${this.API_URL}/DemandeIntervention/Med`);
    }

    getDemandeInterventionLab() {
        return  this.httpClient.get(`${this.API_URL}/DemandeIntervention/Lab`);
    }

    getDemandeInterventionId(val1) {
        return  this.httpClient.get(`${this.API_URL}/DemandeIntervention/Search/`+val1);
    }

    updateDemandeIntervention(dIntervention) {
        return  this.httpClient.put(`${this.API_URL}/DemandeIntervention/Update/`, dIntervention, this.httpOptions);
    }

    deleteDemandeIntervention(id) {
        //return  this.httpClient.put(`${this.API_URL}/DemandeIntervention/Delete/`+id, this.httpOptions);
    }
}
