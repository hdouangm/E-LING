import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/api.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-acceder-dmp',
  templateUrl: './acceder-dmp.component.html',
  styleUrls: ['./acceder-dmp.component.css']
})

export class AccederDmpComponent implements OnInit {
  patient: any;
  dmp: any;
  private location: Location;

  Profession: string;
  constructor(private  apiService: ApiService, private router: Router, private activateRoute: ActivatedRoute ) {
  }

  ngOnInit() {
    this.getDmp();
  }

  getDmp(): void {

    const id = this.activateRoute.snapshot.paramMap.get('id');
    this.apiService.getPatient(`${id}`).subscribe((response: object) => {
      this.patient = response;
    });
    this.apiService.getDMPP(`${id}`).subscribe((responses: object) => {
      this.dmp = responses;
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

    console.log(this.dmp.ss);
    if (this.dmp.Profession === null) {
      return true;
    }
    return false;

  }
  modif(profession) {

    console.log(profession);
    this.dmp.profession = profession;
    this.apiService.setProf(this.dmp);
    this.getDmp();
  }

}
