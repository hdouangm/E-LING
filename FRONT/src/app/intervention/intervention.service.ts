import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Intervention } from 'src/app/datamodel/dataModel';



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

  getInterventionByIDDMP(ID: number): Observable<Intervention> {
    return this.http.get<Intervention>(API_URL + '/all/dmp/' + ID);
  }

  getInterventionByIDResp(ID: number): Observable<Intervention> {
    return this.http.get<Intervention>(API_URL + '/all/responsable/' + ID);
  }

  deleteInterventionByID(ID: number): Observable<Intervention> {
    return this.http.delete<Intervention>(API_URL + '/delete/' + ID);
  }

}
