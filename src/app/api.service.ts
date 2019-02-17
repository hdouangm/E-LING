import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
    API_URL  = 'http://localhost:8080/OphelieComposants-1/rs';

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

    getDemandeExamenId(val1) {
        return  this.httpClient.get(`${this.API_URL}/DemandeExamen/Search/`+val1);
    }

    updateDemandeExamen(id, dExamen) {
        return  this.httpClient.put(`${this.API_URL}/DemandeExamen/Update/`+id, dExamen);
    }

    deleteDemandeExamen(id) {
        //return  this.httpClient.put(`${this.API_URL}/DemandeExamen/Delete/`+id);
    }

    createDemandeIntervention(dIntervention) {
        return  this.httpClient.post(`${this.API_URL}/DemandeIntervention/`, dIntervention);
    }

    getDemandeIntervention() {
        return  this.httpClient.get(`${this.API_URL}/DemandeIntervention`);
    }

    getDemandeInterventionId(val1) {
        return  this.httpClient.get(`${this.API_URL}/DemandeIntervention/Search/`+val1);
    }

    updateDemandeIntervention(id, dIntervention) {
        return  this.httpClient.put(`${this.API_URL}/DemandeIntervention/Update/`+id, dIntervention);
    }

    deleteDemandeIntervention(id) {
        //return  this.httpClient.put(`${this.API_URL}/DemandeIntervention/Delete/`+id);
    }
}
