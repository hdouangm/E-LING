import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-deconnexion',
  templateUrl: './deconnexion.component.html',
  styleUrls: ['./deconnexion.css']
})
export class DeconnexionComponent implements OnInit {

  constructor(private  apiService: ApiService, private router: Router) { }

  ngOnInit() {
    this.apiService.deconnexion();
    this.router.navigate(['connexion']);
    localStorage.removeItem('niveau');
    localStorage.removeItem('nom');
    localStorage.removeItem('prenom');
    localStorage.removeItem('id');

  }

}
