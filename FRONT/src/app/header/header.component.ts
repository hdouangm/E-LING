import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  getUsername() {
    return localStorage.getItem('nom');
  }
  getPrenom() {
    return localStorage.getItem('prenom');

  }
  getNiveau() {
    return Number(localStorage.getItem('niveau'));

  }

}
