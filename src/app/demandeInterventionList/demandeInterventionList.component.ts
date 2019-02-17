import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-demandeInterventionList',
  templateUrl: './demandeInterventionList.component.html',
  styleUrls: ['./demandeInterventionList.component.css']
})
export class DemandeInterventionListComponent implements OnInit {

  public  demandeInterventions:  Array<object> = [];

  constructor(private  apiService:  ApiService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
      this.getDemandeIntervention();
  }

  public getDemandeIntervention() {
      this.apiService.getDemandeIntervention().subscribe((data:  Array<object>) => {
          this.demandeInterventions  =  data;
      });
  }

    public delete(id){
        this.apiService.deleteDemandeIntervention(id).subscribe((response) => {
            console.log(response);
            this.router.navigate(['/demandeIntervention']);
        });
    }

}
