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
  Motif: string;
  MaladieI: string;
  IC: string;
  AutreA: string;
  Accidents: string;
  Maladie: string;
  Allergie: string;
  AC: string;
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
      this.Profession = this.dmp.profession;
      this.Motif = this.dmp.motif;
      this.AC = this.dmp.affectionCongenitales;
      this.MaladieI = this.dmp.maladieInfectieuse;
      this.AutreA = this.dmp.autreAffections;
      this.IC = this.dmp.interventionsChir;
      this.Accidents = this.dmp.accidents;
      this.Maladie = this.dmp.maladies;
      this.Allergie = this.dmp.allergies;
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
  getBD() {
    return this.patient.donneesSociales.age;
  }
  getCP() {
    return this.patient.donneesSociales.codePostal;
  }

  prof() {

    if (this.dmp.profession === null) {
      return false;
    }
    return true;

  }
  modif() {

    if (this.Profession !== 'undefined') {
      this.dmp.profession = this.Profession;
    }
    if (this.Motif) {
      this.dmp.motif = this.Motif;

    }
    if (this.MaladieI) {
      this.dmp.maladieInfectieuse = this.MaladieI;

    }
    if (this.IC) {
    this.dmp.interventionsChir = this.IC;
    }
    if (this.Accidents) {
    this.dmp.accidents = this.Accidents;
    }
    if (this.AutreA) {
    this.dmp.autreAffections = this.AutreA;
    }
    if (this.Maladie) {
    this.dmp.maladies = this.Maladie;
    }
    if (this.Allergie) {
    this.dmp.allergies = this.Allergie;
    }
    if (this.AC) {
    this.dmp.affectionCongenitales = this.AC;
    }
    this.apiService.setProf(this.dmp).subscribe( (response: any) => {



    });
  }

  motif() {
    if (this.dmp.motif === null) {
      return false;
    }
    return true;
  }

  mi() {
    if ( this.dmp.maladieInfectieuse === null) {
      return false;
    }
    return true;  }

  ic() {
    if (this.dmp.interventionsChir === null) {
      return false;
    }
    return true;  }

  accidents() {
    if (this.dmp.accidents === null) {
      return false;
    }
    return true;
  }

  autrea() {
    if (this.dmp.autreAffections === null) {
      return false;
    }
    return true;
  }

  maladie() {
    if (this.dmp.maladies === null) {
      return false;
    }
    return true;
  }

  Allergies() {
    if (this.dmp.allergies === null) {
      return false;
    }
    return true;  }

  ac() {
    if (this.dmp.affectionCongenitales === null) {
      return false;
    }
    return true;
  }
}
