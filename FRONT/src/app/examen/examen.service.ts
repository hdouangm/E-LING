import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Examen } from '../datamodel/examen';


const API_URL = environment.apiUrl + '/examens';


@Injectable({
  providedIn: 'root'
})
export class ExamenService {

  constructor(private http: HttpClient) { }

  getExamenByID(ID: number): Observable<Examen> {
      return this.http.get<Examen>(API_URL + '/get/' + ID);
  }

  getAllExamens(): Observable<Array<Examen>> {
      return this.http.get<Array<Examen>>(API_URL + '/all');
  }

  createExamen(examen: Examen): Observable<Examen> {
      return this.http.post<Examen>(API_URL + '/create', examen);
  }

  getExamenByIDDMP(ID: number): Observable<Examen> {
    return this.http.get<Examen>(API_URL + '/all/dmp/' + ID);
  }

  getExamenByIDResp(ID: number): Observable<Examen> {
    return this.http.get<Examen>(API_URL + '/all/responsable/' + ID);
  }

  deleteExamenByID(ID: number): Observable<Examen> {
    return this.http.delete<Examen>(API_URL + '/delete/' + ID);
  }

}
