import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/api.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-acceder-dmp',
  templateUrl: './acceder-dmp.component.html',
  styleUrls: ['./acceder-dmp.component.css']
})

export class AccederDmpComponent implements OnInit {
  private dmp;
  private location: Location;

  constructor(private  apiService:  ApiService, private router: Router, private activateRoute: ActivatedRoute ) {
  }

  ngOnInit() {
    this.getDmp();
  }

  getDmp(): void {

    const id = this.activateRoute.snapshot.paramMap.get('id');
    this.apiService.getDMP(`${id}`)
      .subscribe(
        (reponse:  Object) => {
        console.log('acceder dmp -> ', reponse);
       this.dmp = reponse;
    },
  error => {
      alert(`Oups une erreur s'est produite.`);
      this.router.navigate(['connexion']);
  });
  }

  goBack(): void {
    this.location.back();
  }

}
