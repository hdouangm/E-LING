import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-demandeExamenAdding',
  templateUrl: './demandeExamenAdding.component.html',
  styleUrls: ['./demandeExamenAdding.component.css']
})
export class DemandeExamenAddingComponent implements OnInit {
  constructor( private  apiService: ApiService, private route: ActivatedRoute, private router: Router ) { }

  @Input() examenData = { id_dmp: localStorage.getItem('id_dmp'), type_examen: '', publicationMed: false, publicationLab: false , publication: ''};

  public  dmps: Array<object> = [];
  public  types: Array<object> = [];

  ngOnInit() {



    this.apiService.getTypeExamen().subscribe((data: Array<object>) => {
          this.types  =  data;
      });

  }

public createDemandeExamen() {
        this.apiService.createDemandeExamen(this.examenData).subscribe((response) => {
            console.log(response);
            location.replace('listePatient');
        });

    }


}
