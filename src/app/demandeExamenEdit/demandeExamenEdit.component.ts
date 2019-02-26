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

  @Input() examenData = { id_dmp:'', type_examen: '', publicationMed: true, publicationLab:false };
  @Input() examenDataUpdate = { id_dmp:'', type_examen: '', publicationMed:true, publicationLab:false  };
  data:  Array<object>;

  public  dmps :  Array<object> = [];
  public  types :  Array<object> = [];

    

  ngOnInit() {

    this.apiService.getDemandeExamenId(this.route.snapshot.params['id']).subscribe(
      (data: {id_dmp: string; type_examen: string; publicationMed: boolean; publicationLab: boolean;}) => {
        this.examenData = data;
        if(this.examenData.publicationLab==true){
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

    var dataUpdate = {
      'id' : this.route.snapshot.params['id'],
      'id_dmp' : this.examenDataUpdate['id_dmp'],
      'type' : this.examenDataUpdate['type'],
      'publicationLab' : this.examenDataUpdate['publicationLab']
    };

    console.log(this.examenDataUpdate);    
    console.log(this.dataUpdate); 
    this.apiService.updateDemandeExamen(this.dataUpdate).subscribe((reponse:  object) => {
        console.log(reponse);
        return; 
        this.router.navigate(['/demandeExamen']);}, (err) => { console.log(err); });
  }

}
