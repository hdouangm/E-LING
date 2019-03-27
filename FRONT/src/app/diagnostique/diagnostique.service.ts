import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Diagnostique } from '../datamodel/data';


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

  getDiagnostiqueByIDDMP(ID: number): Observable<Array<Diagnostique>> {
    return this.http.get<Array<Diagnostique>>(API_URL + '/all/dmp/' + ID);
  }

  getDiagnostiqueByIDResp(ID: number): Observable<Diagnostique> {
    return this.http.get<Diagnostique>(API_URL + '/all/responsable/' + ID);
  }

  deleteDiagnostiqueByID(ID: number): Observable<Diagnostique> {
    return this.http.delete<Diagnostique>(API_URL + '/delete/' + ID);
  }

  linkDMP(idDiagnostique: number, idDmp: number): Observable<Diagnostique> {
        const formdata: FormData = new FormData();
        formdata.append('diagnostique', idDiagnostique.toString());
        formdata.append('dmp', idDmp.toString());
        return this.http.post<Diagnostique>(API_URL + '/linkDMP', formdata);

  }


  linkResponsable(idDiagnostique: number, idRes: number): Observable<Diagnostique> {
        const formdata: FormData = new FormData();
        formdata.append('diagnostique', idDiagnostique.toString());
        formdata.append('res', idRes.toString());
        return this.http.post<Diagnostique>(API_URL + '/linkDemande', formdata);

  }

}

