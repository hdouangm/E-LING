import {Component, ElementRef, OnInit} from '@angular/core';
import {style} from '@angular/animations';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  un: boolean;
  deux:boolean;
  trois:boolean;
  quatre:boolean;
  constructor(private elementRef: ElementRef) {     this.un = true;
  }
  ngOnInit() {
  }
  getUsername() {
    return localStorage.getItem('nom');
  }
  getPrenom() {
    return localStorage.getItem('prenom');

  }
  getNiveau() {
    return localStorage.getItem('niveau');

  }
  modif(num){
    if(num === 'un'){
      this.deux = false;
      this.trois = false;
      this.quatre = false;
      this.un = true;
      this.elementRef.nativeElement.style.setProperty('--mar-za', '-2%');


    }
    if(num === 'deux') {
      this.un = false;
      this.trois = false;
      this.quatre = false;
      this.deux = true;
      this.elementRef.nativeElement.style.setProperty('--mar-za', '18%');
    }
    if(num === 'trois'){
      this.deux = false;
      this.un = false;
      this.quatre = false;
      this.trois = true;
      this.elementRef.nativeElement.style.setProperty('--mar-za', '38%');


    }
    if(num === 'quatre'){
      this.deux = false;
      this.trois = false;
      this.un = false;
      this.quatre = true;
      this.elementRef.nativeElement.style.setProperty('--mar-za', '60%');


    }



  }
  modif2(num){
    if(num === 'un'){
      this.deux = false;
      this.trois = false;
      this.quatre = false;
      this.un = true;
      this.elementRef.nativeElement.style.setProperty('--mar-za', '-2%');


    }
    if(num === 'deux') {
      this.un = false;
      this.trois = false;
      this.quatre = false;
      this.deux = true;
      this.elementRef.nativeElement.style.setProperty('--mar-za', '16%');
    }
    if(num === 'trois'){
      this.deux = false;
      this.un = false;
      this.quatre = false;
      this.trois = true;
      this.elementRef.nativeElement.style.setProperty('--mar-za', '35%');


    }
    if(num === 'quatre'){
      this.deux = false;
      this.trois = false;
      this.un = false;
      this.quatre = true;
      this.elementRef.nativeElement.style.setProperty('--mar-za', '50%');


    }



  }

}
