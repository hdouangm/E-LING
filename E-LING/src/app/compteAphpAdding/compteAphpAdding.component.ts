import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-compteAphpAdding',
  templateUrl: './compteAphpAdding.component.html',
  styleUrls: ['./compteAphpAdding.component.css']
})

export class CompteAphpAddingComponent implements OnInit {

  public  comptes:  Array<object> = [];

  constructor(private  apiService:  ApiService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
      
  }


    public createCompteAphp(val1, val2) {
        const compte  = {
                username:  val1,
                password:  val2,
                langue :  1
            };
        this.apiService.createCompteAphp(compte).subscribe((response) => {
            console.log(response);
            this.router.navigate(['/compteAphp']);
        });
    }


}
