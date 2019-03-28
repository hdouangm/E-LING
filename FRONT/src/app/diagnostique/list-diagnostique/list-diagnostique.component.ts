import { Component, OnInit, Input } from '@angular/core';
import { DiagnostiqueService } from '../diagnostique.service';
import { Diagnostique } from 'src/app/datamodel/data';
import { RouterLink, ActivatedRoute } from '@angular/router';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-listdiagnostique',
  templateUrl: './list-diagnostique.component.html',
  styleUrls: ['./list-diagnostique.component.css']
})
export class ListdiagnostiqueComponent implements OnInit {

    public list: Array<Diagnostique>;
  waitingDiag:string;
  waitingPos:string;
  dmp: any;

  valDiag(id){

    this.service.getDiagnostiqueByID(id).subscribe((response) => {
      response.publication = false;
      this.service.update(response).subscribe((response) => {

      });

    });
  }
  suppDiag(id){
    this.service.getDiagnostiqueByID(id).subscribe((response) => {
      response.delested = true;
      this.service.update(response).subscribe((response) => {


      });

    });


  }


  constructor(private  apiService: ApiService, public service: DiagnostiqueService, public router: ActivatedRoute) { }

  ngOnInit() {
    const id = localStorage.getItem('patient_id');
    this.apiService.getPatient(`${id}`).subscribe((response:  any) => {

      this.dmp = response.dmp;
    });

    this.router.snapshot.paramMap.get('id');
    // tslint:disable-next-line:radix
    this.service.getDiagnostiqueByIDDMP(Number.parseInt(this.router.snapshot.paramMap.get('id'))).subscribe(
        (res) => this.list = res.reverse());
    // this.service.getAllDiagnostiques().subscribe((res) => this.list = res);
  }

}
