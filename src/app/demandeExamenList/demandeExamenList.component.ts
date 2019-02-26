import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-demandeExamenList',
  templateUrl: './demandeExamenList.component.html',
  styleUrls: ['./demandeExamenList.component.css']
})
export class DemandeExamenListComponent implements OnInit {

  public  demandeExamens:  Array<object> = [];

  constructor(private  apiService:  ApiService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
      this.getDemandeExamen();
  }

  public getDemandeExamen() {
      this.apiService.getDemandeExamen().subscribe((data:  Array<object>) => {
          this.demandeExamens  =  data;
            console.log(this.demandeExamens);
      });
  }

}
