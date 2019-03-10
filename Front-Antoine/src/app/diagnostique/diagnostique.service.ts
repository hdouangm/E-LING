import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Diagnostique } from '../datamodel/diagnostique';


const API_URL = environment.apiUrl + '/diagnostiques';


@Injectable({
  providedIn: 'root'
})
export class DiagnostiqueService {

  constructor(private http: HttpClient) { }

  getDiagnostiqueByID(ID: number): Observable<Diagnostique> {
      return this.http.get<Diagnostique>(API_URL + '/get/' + ID);
  }

  getAllDiagnostiques(): Observable<Array<Diagnostique>> {
      return this.http.get<Array<Diagnostique>>(API_URL + '/all');
  }

  createDiagnostique(diagnostique: Diagnostique): Observable<Diagnostique> {
      return this.http.post<Diagnostique>(API_URL + '/create', diagnostique);
  }

  getDiagnostiqueByIDDMP(ID: number): Observable<Diagnostique> {
    return this.http.get<Diagnostique>(API_URL + '/all/dmp/' + ID);
  }

  getDiagnostiqueByIDResp(ID: number): Observable<Diagnostique> {
    return this.http.get<Diagnostique>(API_URL + '/all/responsable/' + ID);
  }

  deleteDiagnostiqueByID(ID: number): Observable<Diagnostique> {
    return this.http.delete<Diagnostique>(API_URL + '/delete/' + ID);
  }

}
