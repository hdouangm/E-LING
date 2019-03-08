import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-demande-intervention-list-lab',
  templateUrl: './demande-intervention-list-lab.component.html',
  styleUrls: ['./demande-intervention-list-lab.component.css']
})
export class DemandeInterventionListLabComponent implements OnInit {

  public  demandeInterventions:  Array<object> = [];

  constructor(private  apiService:  ApiService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
      this.getDemandeIntervention();
  }

  public getDemandeIntervention() {
      this.apiService.getDemandeInterventionLab().subscribe((data:  Array<object>) => {
          this.demandeInterventions  =  data;
            console.log(this.demandeInterventions);
      });
  }

}
