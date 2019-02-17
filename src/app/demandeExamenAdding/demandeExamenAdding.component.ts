import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-demandeExamenAdding',
  templateUrl: './demandeExamenAdding.component.html',
  styleUrls: ['./demandeExamenAdding.component.css']
})
export class DemandeExamenAddingComponent implements OnInit {

  constructor( private  apiService:  ApiService, private route: ActivatedRoute, private router: Router ) { }

  @Input() examenData = { id_dmp:'', type: '', publication: true };

  public  dmps :  Array<object> = [];
  public  types :  Array<object> = [];

  ngOnInit() {
    
    this.apiService.getCompteAphp().subscribe((data:  Array<object>) => {
          this.dmps  =  data;
      });

    this.apiService.getCompteAphp().subscribe((data:  Array<object>) => {
          this.types  =  data;
      });
    
  }

public createDemandeExamen() {
        this.apiService.createDemandeExamen(this.examenData).subscribe((response) => {
            console.log(response);
            this.router.navigate(['/demandeExamen']);
        });
    }


}
