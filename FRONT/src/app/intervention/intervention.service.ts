import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Intervention } from '../datamodel/data';


const API_URL = environment.apiUrl + '/interventions';


@Injectable({
  providedIn: 'root'
})
export class InterventionService {

  constructor(private http: HttpClient) { }

  getInterventionByID(ID: number): Observable<Intervention> {
      return this.http.get<Intervention>(API_URL + '/get/' + ID);
  }

  getAllInterventions(): Observable<Array<Intervention>> {
      return this.http.get<Array<Intervention>>(API_URL + '/all');
  }

  createIntervention(intervention: Intervention): Observable<Intervention> {
      return this.http.post<Intervention>(API_URL + '/create', intervention);
  }

  getInterventionByIDDMP(ID: number): Observable<Array<Intervention>> {
    return this.http.get<Array<Intervention>>(API_URL + '/all/dmp/' + ID);
  }

  getInterventionByIDResp(ID: number): Observable<Intervention> {
    return this.http.get<Intervention>(API_URL + '/all/responsable/' + ID);
  }

  deleteInterventionByID(ID: number): Observable<Intervention> {
    return this.http.delete<Intervention>(API_URL + '/delete/' + ID);
  }

  linkDMP(idIntervention: number, idDmp: number): Observable<Intervention> {
        const formdata: FormData = new FormData();
        formdata.append('intervention', idIntervention.toString());
        formdata.append('dmp', idDmp.toString());
        return this.http.post<Intervention>(API_URL + '/linkDMP', formdata);

  }

  linkDemande(idIntervention: number, idDemande: number): Observable<Intervention> {
        const formdata: FormData = new FormData();
        formdata.append('intervention', idIntervention.toString());
        formdata.append('demande', idDemande.toString());
        return this.http.post<Intervention>(API_URL + '/linkDemande', formdata);

  }

  linkResponsable(idIntervention: number, idRes: number): Observable<Intervention> {
        const formdata: FormData = new FormData();
        formdata.append('intervention', idIntervention.toString());
        formdata.append('res', idRes.toString());
        return this.http.post<Intervention>(API_URL + '/linkDemande', formdata);

  }

}
