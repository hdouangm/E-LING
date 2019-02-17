import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-demandeInterventionEdit',
  templateUrl: './demandeInterventionEdit.component.html',
  styleUrls: ['./demandeInterventionEdit.component.css']
})
export class DemandeInterventionEditComponent implements OnInit {

  constructor(private  apiService:  ApiService, private route: ActivatedRoute, private router: Router) { }

  @Input() interventionData = { id_dmp:'', type: '', publication: true };
  @Input() interventionDataUpdate = { id_dmp:'', type: '', publication:true  };
  data:  Array<object>;

  public  dmps :  Array<object> = [];
  public  types :  Array<object> = [];

  ngOnInit() {

    this.apiService.getDemandeInterventionId(this.route.snapshot.params['id']).subscribe(
      (data: {id_dmp: string; type: string; publication: boolean;}) => {
        this.interventionData = data;
        if(this.interventionData.publication==true){
            this.router.navigate(['/demandeIntervention']);
        }
    });
    

    this.apiService.getCompteAphp().subscribe((data:  Array<object>) => {
          this.dmps  =  data;
      });

    this.apiService.getCompteAphp().subscribe((data:  Array<object>) => {
          this.types  =  data;
      });

  }

  updateDemandeIntervention() {
    console.log(this.interventionDataUpdate);    
    this.apiService.updateDemandeIntervention(this.route.snapshot.params['id'], this.interventionDataUpdate).subscribe(
        (result) => { this.router.navigate(['/demandeIntervention']);}, (err) => { console.log(err); });
  }

}
