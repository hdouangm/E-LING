import { Component, OnInit, Input } from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-demandeInterventionAdding',
  templateUrl: './demandeInterventionAdding.component.html',
  styleUrls: ['./demandeInterventionAdding.component.css']
})
export class DemandeInterventionAddingComponent implements OnInit {

  constructor( private  apiService:  ApiService, private route: ActivatedRoute, private router: Router ) { }

  @Input() interventionData = { id_dmp:'', type_intervention: '', publicationMed: false, publicationLab:false };

  public  dmps :  Array<object> = [];
  public  types :  Array<object> = [];

  ngOnInit() {
    this.apiService.getCompteAphp().subscribe((data:  Array<object>) => {
          this.dmps  =  data;
      });

    this.apiService.getTypeIntervention().subscribe((data:  Array<object>) => {
          this.types  =  data;
      });
  }

public createDemandeIntervention() {
        //console.log(this.interventionData);
        this.apiService.createDemandeIntervention(this.interventionData).subscribe((response) => {
            console.log(response);
            this.router.navigate(['/demandeInterventionMed']);
        });
    }


}
