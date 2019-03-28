import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Posologie, DMP } from '../datamodel/data';


const API_URL = environment.apiUrl + '/posologies';


@Injectable({
  providedIn: 'root'
})
export class PosologieService {

  constructor(private http: HttpClient) { }

  getPosologieByID(ID: number): Observable<Posologie> {
      return this.http.get<Posologie>(API_URL + '/get/' + ID);
  }

  getAllPosologies(): Observable<Array<Posologie>> {
      return this.http.get<Array<Posologie>>(API_URL + '/all');
  }

  createPosologie(posologie: Posologie): Observable<Posologie> {
      return this.http.post<Posologie>(API_URL + '/create', posologie);
  }

  getPosologieByIDDMP(ID: number): Observable<Array<Posologie>> {
    return this.http.get<Array<Posologie>>(API_URL + '/all/dmp/' + ID);
  }

  getPosologieByIDResp(ID: number): Observable<Posologie> {
    return this.http.get<Posologie>(API_URL + '/all/responsable/' + ID);
  }

  deletePosologieByID(ID: number): Observable<Posologie> {
    return this.http.delete<Posologie>(API_URL + '/delete/' + ID);
  }

  linkDMP(idPosologie: number, idDmp: number): Observable<Posologie> {
        const formdata: FormData = new FormData();
        formdata.append('posologie', idPosologie.toString());
        formdata.append('dmp', idDmp.toString());
        return this.http.post<Posologie>(API_URL + '/linkDMP', formdata);

  }


  linkResponsable(idPosologie: number, idRes: number): Observable<Posologie> {
        const formdata: FormData = new FormData();
        formdata.append('posologie', idPosologie.toString());
        formdata.append('res', idRes.toString());
        return this.http.post<Posologie>(API_URL + '/linkDemande', formdata);

  }

  getDMP(id: string) {
    return this.http.get<DMP>(environment.apiUrl + '/DMP/' + id);
  }
}
