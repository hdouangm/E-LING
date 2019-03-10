import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';
import { Observable } from 'rxjs';
import { HttpClient, HttpRequest, HttpHeaders } from '@angular/common/http';
import { Examen } from '../datamodel/examen';
import { Intervention } from 'src/app/datamodel/intervention';

const API_URL = environment.apiUrl + '/file';
@Injectable({
  providedIn: 'root'
})
export class FileService {


  constructor(private http: HttpClient) { }

    uploadFile(file: File, dir: string): void {
        const formdata: FormData = new FormData();
        formdata.append('file', file);
        formdata.append('dir', dir);

        this.http.post(API_URL + '/upload', formdata).subscribe(res => console.log(res));
    }

    getExamResultURL(examen: Examen): string {
        return API_URL + '/download/Examen' + examen.id;
    }

    getInterventionResultURL(intervention: Intervention): string {
        return API_URL + '/download/Examen' + intervention.id;
    }

}
