import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-demandeExamenEdit',
  templateUrl: './demandeExamenEdit.component.html',
  styleUrls: ['./demandeExamenEdit.component.css']
})
export class DemandeExamenEditComponent implements OnInit {

  constructor(private  apiService:  ApiService, private route: ActivatedRoute, private router: Router) { }

  @Input() examenData = { id_dmp:'', type: '', publication: true };
  @Input() examenDataUpdate = { id_dmp:'', type: '', publication:true  };
  data:  Array<object>;

  public  dmps :  Array<object> = [];
  public  types :  Array<object> = [];

  ngOnInit() {

    this.apiService.getDemandeExamenId(this.route.snapshot.params['id']).subscribe(
      (data: {id_dmp: string; type: string; publication: boolean;}) => {
        this.examenData = data;
        if(this.examenData.publication==true){
            this.router.navigate(['/demandeExamen']);
        }
    });
    

    this.apiService.getCompteAphp().subscribe((data:  Array<object>) => {
          this.dmps  =  data;
      });

    this.apiService.getCompteAphp().subscribe((data:  Array<object>) => {
          this.types  =  data;
      });

  }

  updateDemandeExamen() {
    console.log(this.examenDataUpdate);    
    this.apiService.updateDemandeExamen(this.route.snapshot.params['id'], this.examenDataUpdate).subscribe(
        (result) => { this.router.navigate(['/demandeExamen']);}, (err) => { console.log(err); });
  }

}
