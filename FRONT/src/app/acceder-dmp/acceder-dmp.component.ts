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
  GS: string;
  GR: string;
  niveau: any;
  employe:any;
  waitingDiag:string;
  waitingPos:string;
  constructor(private  apiService: ApiService, private router: Router, private activateRoute: ActivatedRoute ) {
  }

  ngOnInit() {
    this.getDmp();
  }

  getDmp(): void {
    const id = this.activateRoute.snapshot.paramMap.get('id');
    localStorage.setItem('patient_id',id);
    this.niveau = localStorage.getItem('niveau');
    this.apiService.getPatient(`${id}`).subscribe((response: object) => {
      this.patient = response;
      this.dmp = this.patient.dmp;
      this.Profession = this.dmp.profession;
      this.Motif = this.dmp.motif;
      this.AC = this.dmp.affectionCongenitales;
      this.MaladieI = this.dmp.maladieInfectieuse;
      this.AutreA = this.dmp.autreAffections;
      this.IC = this.dmp.interventionsChir;
      this.Accidents = this.dmp.accidents;
      this.Maladie = this.dmp.maladies;
      this.Allergie = this.dmp.allergies;
      this.GS = this.dmp.groupeSanguin;
      this.GR = this.dmp.groupeRhesus;
      this.waitingDiag = this.dmp.waitingDiag;
      this.waitingPos = this.dmp.waitingPos;
      this.dmp.waiting = 'false';

      this.apiService.setProf(this.dmp).subscribe((response: object) => {


      });
    });
    this.apiService.getEmployeConnecte().subscribe((response: object) => {
      this.employe = response;
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
    if (this.Profession) {
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
    if(this.GS) {
      this.dmp.groupeSanguin = this.GS;
    }
    if (this.GR) {
      this.dmp.groupeRhesus = this.GR;
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

  gs() {
    if (this.dmp.groupeSanguin === null) {
      return false;
    }
    console.log(this.dmp.groupeSanguin);
    return true;
  }

  gr() {
    if (this.dmp.groupeRhesus === null) {
      return false;
    }
    return true;

  }

  diagnostique() {
    this.dmp.waiting = 'false';

    this.dmp.waitingDiag = 'waiting';
    this.apiService.setProf(this.dmp).subscribe((response: object) => {


    });

  }

  valPos() {
    this.waitingPos = 'check';
    this.dmp.waitingPos = 'check';
    this.apiService.setProf(this.dmp).subscribe((response: object) => {


    });
    this.valDiag();
  }

  posologie() {
    this.waitingPos = 'check';
    this.dmp.waitingPos = 'waiting';
    this.apiService.setProf(this.dmp).subscribe((response: object) => {


    });
  }

  valDiag() {

    this.dmp.waitingDiag = 'check';
    this.waitingDiag = 'check';
    this.apiService.setProf(this.dmp).subscribe((response: object) => {


    });
  }

  demandeExamen() {
    localStorage.setItem('id_dmp', this.dmp.id);
    location.replace('addDemandeExamen');

  }

  demandeIntervention() {
    localStorage.setItem('id_dmp', this.dmp.id);
    location.replace('addDemandeIntervention');
  }
}
