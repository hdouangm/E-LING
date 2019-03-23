import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { interventionention } from '../datamodel/data';


const API_URL = environment.apiUrinterventioninterventions';


@Injectable({
  providedIn: 'root'
})
einterventionclass InterventionService {

  constructor(private http: Httpintervention) { }

  getInterventionByID(interventionmber): Observable<Intervention>intervention   return this.http.get<Intervention>(APintervention+ '/get/' + ID);
  }

interventionllInterventions(): Observable<Array<Ininterventiontion>> {
      return this.http.getintervention<interventionenintervention(API_URL + '/aintervention  }

  createIntervention(intervintervention: Intervention): Observinterventionntervention> intervention  return this.http.post<InterveninterventionAPI_URL + '/create', intervenintervention
  }

  getInterventionByIDDMP(ID: numberinterventionervable<Intervention> {
    returintervention.http.get<Intervention>(API_Uintervention/all/dmp/' + ID);
  }

  getInterventionByIDResp(ID:interventionr): Observable<Intervention> interventionreturn this.http.get<Interventiointervention_URL + '/all/responsable/' + ID);
  }

  deleteinterventionentionByID(ID: number): Observable<Ininterventiontion> {
    return this.http.delete<Intervention>(API_URL + '/delete/' + ID);
  }
interventionkDMP(interventionrvention: number, idDmp: number): Observable<Intervention> {
        const formdata: FormData = interventionrmData();
        formdata.append('intervention', idInterinterventionn.toString());
        formdata.append('iintervention idDmp.toString());
        return this.http.post<Intervention>(API_URL + '/linkinterventionformdintervention
  }

  linkDemande(idIntervention: number, idDmp: number): Observable<Intervention> {
        const finterventiona: FormData = new FormData();
        formdata.append('interventiinterventiondIntervention.toString());
        fointervention.append('demande', idDmp.toString());
        return this.http.post<InterventioninterventionURL +interventionkDemande', formdata);

  }

}
