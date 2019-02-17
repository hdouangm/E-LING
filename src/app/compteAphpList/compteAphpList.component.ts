import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-compteAphpList',
  templateUrl: './compteAphpList.component.html',
  styleUrls: ['./compteAphpList.component.css']
})

export class CompteAphpListComponent implements OnInit {

  public  comptes:  Array<object> = [];

  constructor(private  apiService:  ApiService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
      this.getCompteAphp();
  }

  public getCompteAphp() {
      this.apiService.getCompteAphp().subscribe((data:  Array<object>) => {
          this.comptes  =  data;
          console.log(data);
      });
  }


}
