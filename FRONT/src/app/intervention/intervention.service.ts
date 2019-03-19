import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.prod';
import { Intervention } from '../datamodel/intervention';


const API_URL = environment.apiUrl + '/intervention';


@Injectable({
  providedIn: 'root'
})

export class InterventionService {
  constructor(private http: HttpClient) { }

  getIntervention(ID: number): Observable<Intervention> {
      return this.http.get<Intervention>(API_URL + '/' + ID);
  }
}
