import { Component, OnInit, Input} from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-compteAphpSearching',
  templateUrl: './compteAphpSearching.component.html',
  styleUrls: ['./compteAphpSearching.component.css']
})

export class CompteAphpSearchingComponent implements OnInit {

    public  comptes: Array<object> = [];

    constructor(private  apiService: ApiService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
    }

    public getCompteAphpAll(val1, val2) {

        this.apiService.getCompteAphpAll(val1, val2).subscribe((data: Array<object>) => {
            this.comptes  =  data;
            console.log(this.comptes);
        });
    }

}
