import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-demande-intervention-list-med',
  templateUrl: './demande-intervention-list-med.component.html',
  styleUrls: ['./demande-intervention-list-med.component.css']
})
export class DemandeInterventionListMedComponent implements OnInit {

  public  demandeInterventions:  Array<object> = [];
  patienttab: Array<any> = [];
  i = 0;
  constructor(private  apiService:  ApiService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
      this.getDemandeIntervention();
  }
  public getPatient(){


    this.demandeInterventions.forEach((x:any) => {

      this.apiService.getPatientDMP(x.id_dmp).subscribe((response:any) => {

        this.patienttab[this.i]  =  response;

        this.i++;
      });

    });

  }

  public newDemande(){
    this.router.navigate(['/addDemandeIntervention']);
  } 

  public publierDemande(id,dmp,type){

    const interventionDataUp = { 
        id:id,
        id_dmp:dmp, 
        type_intervention:type, 
        publicationMed: true, 
        publicationLab:false };

    //console.log(interventionDataUp); 
    this.apiService.updateDemandeIntervention(interventionDataUp).subscribe((reponse:  object) => {
        console.log(reponse);
        this.router.navigate(['/demandeInterventionMed']);});
  } 

  public getDemandeIntervention() {
      this.apiService.getDemandeInterventionMed().subscribe((data:  Array<object>) => {
          this.demandeInterventions  =  data;
            console.log(this.demandeInterventions);
            this.getPatient();

      });
  }


}
