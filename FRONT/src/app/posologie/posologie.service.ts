import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Posologie } from 'src/app/datamodel/dataModel';


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

  getPosologieByIDDMP(ID: number): Observable<Posologie> {
    return this.http.get<Posologie>(API_URL + '/all/dmp/' + ID);
  }

  getPosologieByIDResp(ID: number): Observable<Posologie> {
    return this.http.get<Posologie>(API_URL + '/all/responsable/' + ID);
  }

  deletePosologieByID(ID: number): Observable<Posologie> {
    return this.http.delete<Posologie>(API_URL + '/delete/' + ID);
  }

}
