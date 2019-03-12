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
      console.log(localStorage.getItem('niveau'));
      return localStorage.getItem('niveau');
  }

}
