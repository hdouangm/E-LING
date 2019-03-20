import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/api.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-acceder-dmp',
  templateUrl: './acceder-dmp.component.html',
  styleUrls: ['./acceder-dmp.component.css']
})

export class AccederDmpComponent implements OnInit {
  patient: any;
  dmp: any;
  private location: Location;
  API_URL = 'http://localhost:8080/Patient-1.0-SNAPSHOT/rs';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  Profession: string;
  constructor
  (private  httpClient: HttpClient,private  apiService: ApiService, private router: Router, private activateRoute: ActivatedRoute ) {
  }

  ngOnInit() {
    this.getDmp();
  }

  getDmp(): void {

    const id = this.activateRoute.snapshot.paramMap.get('id');
    this.apiService.getPatient(`${id}`).subscribe((response: object) => {
      this.patient = response;
    });
    this.apiService.getDMP(`${id}`).subscribe((response: object) => {
      this.dmp = response;
    });

  }

  goBack(): void {
    this.location.back();
  }
  getNom() {
    return this.patient.donneesSociales.nom;
  }
  getPrenom() {
    return this.patient.donneesSociales.prenom;
  }
  getBD(){
    return this.patient.donneesSociales.age;
  }
  getCP(){
    return this.patient.donneesSociales.codePostal;
  }

  prof() {
    console.log(this.dmp.ss)
    if (this.dmp.Profession === null) {
      return true;
    }
    return false;

  }
  modif(profession) {

    console.log('lalala')
    this.httpClient.post(`${this.API_URL}/DMP/profession`,this.activateRoute.snapshot.paramMap.get('id'), profession);

  }

}
