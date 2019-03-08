import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private apiService: ApiService) { }

  private currentUser: any;

  ngOnInit() {
    this.currentUser = this.apiService.getEmployeConnecte();
    console.log('menu : ', JSON.stringify( this.currentUser));
  }



}
