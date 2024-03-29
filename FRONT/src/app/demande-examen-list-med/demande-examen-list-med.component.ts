import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-demande-examen-list-med',
  templateUrl: './demande-examen-list-med.component.html',
  styleUrls: ['./demande-examen-list-med.component.css']
})
export class DemandeExamenListMedComponent implements OnInit {

  public  demandeExamens:  Array<object> = [];
  patienttab: Array<any> = [];
i = 0;
  constructor(private  apiService:  ApiService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
      this.getDemandeExamen();
  }

  public newDemande(){
    this.router.navigate(['/addDemandeExamen']);
  } 

  public publierDemande(id,dmp,type){

    const examenDataUp = { 
        id:id,
        id_dmp:dmp, 
        type_examen:type, 
        publicationMed: true, 
        publicationLab:false };

    //console.log(examenDataUp); 
    this.apiService.updateDemandeExamen(examenDataUp).subscribe((reponse:  object) => {
        console.log(reponse);
        this.router.navigate(['/demandeExamenMed']);});
  }
  public getPatient(){


    this.demandeExamens.forEach((x:any) => {

      this.apiService.getPatientDMP(x.id_dmp).subscribe((response:any) => {

        this.patienttab[this.i]  =  response;
        console.log(response);

        console.log(this.demandeExamens);
        this.i++;
      });

    });

  }
  public getDemandeExamen() {
      this.apiService.getDemandeExamenMed().subscribe((data:  Array<object>) => {
          this.demandeExamens  =  data;
            console.log(this.demandeExamens);
            this.getPatient();

      });
  }

}
