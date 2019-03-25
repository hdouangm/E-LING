import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-demande-examen-list-lab',
  templateUrl: './demande-examen-list-lab.component.html',
  styleUrls: ['./demande-examen-list-lab.component.css']
})
export class DemandeExamenListLabComponent implements OnInit {

  public  demandeExamens:  Array<any> = [];
  patienttab: Array<any> = [];
  i = 0;
  constructor(private  apiService:  ApiService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
      this.getDemandeExamen();

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
      this.apiService.getDemandeExamenLab().subscribe((data:  Array<any>) => {
          this.demandeExamens  =  data;
            console.log(this.demandeExamens);
          this.getPatient();

      });
  }
}
