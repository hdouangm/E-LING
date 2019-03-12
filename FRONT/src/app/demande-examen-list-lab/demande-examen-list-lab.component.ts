import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-demande-examen-list-lab',
  templateUrl: './demande-examen-list-lab.component.html',
  styleUrls: ['./demande-examen-list-lab.component.css']
})
export class DemandeExamenListLabComponent implements OnInit {

  public  demandeExamens:  Array<object> = [];

  constructor(private  apiService:  ApiService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
      this.getDemandeExamen();
  }

  public getDemandeExamen() {
      this.apiService.getDemandeExamenLab().subscribe((data:  Array<object>) => {
          this.demandeExamens  =  data;
            console.log(this.demandeExamens);
      });
  }
}
