import { Component, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { environment } from './../../environments/environment';
import { Injectable } from "@angular/core";
import { Input } from '@angular/core';

@Component({
  selector: 'app-coder-acte',
  templateUrl: './coder-acte.component.html',
  styleUrls: ['./coder-acte.component.css']
})

export class CoderActeComponent implements OnInit{

  @Input() idtype: number;
  @Input() typef: string;
  list: any;
  actes: any;
  restItemsUrl = environment.apiUrl+'/medecin/';


  constructor(private http: HttpClient) { }

  ngOnInit() {
  	this.getRestItems();
  }	

  actefilter() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById("Input");
    filter = input.value.toUpperCase();
    ul = document.getElementById("Ul");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
  }

  getRestItems(){
    this.listactes()
      .subscribe(
        listactes => {
          this.list = listactes;
          console.log(this.list);

          this.getactes(this.typef,this.idtype)
            .subscribe(
        		actes => {
          		this.actes = actes;
          		this.refreshlist();
          		console.log(this.actes);
        		},
        		err => {
        			alert("Une erreur est survenue lors de la recherche des actes.")
        		}
      		);
        },
        err => {
        	alert("Une erreur est survenue lors de l'affichage des actes.")
        }
      );
  }

  listactes() {
    return this.http
      .get<any[]>(this.restItemsUrl+"listacte")
      .pipe(map(data => data));
  }

  getprix(){
    var sum  = 0;
    for (var item in this.actes){
      sum = sum + this.actes[item].prix;
    }
    return sum;
  }

  getactes(type, id) {
    return this.http
      .get<any[]>(this.restItemsUrl+"getacte?type="+type+"&id="+id)
      .pipe(map(data => data));
  }

  click (idacte,type,id){
  	var a = document.getElementById(idacte).style.backgroundColor;
  	if (a == "rgb(238, 238, 238)" || a == "rgb(246, 246, 246)" || a == ""){
  		document.getElementById(idacte).style.backgroundColor = "#3499D9";
  		document.getElementById(idacte).onmouseover = function() {
    		document.getElementById(idacte).style.backgroundColor = "#1c72a8";
    	};
    	document.getElementById(idacte).onmouseout = function() {
    		document.getElementById(idacte).style.backgroundColor = "#3499D9";
    	};
    	this.submit(idacte,type,id);
    	this.getRestItems();

  	}else {
  		document.getElementById(idacte).style.backgroundColor = "#f6f6f6";
  		document.getElementById(idacte).onmouseover = function() {
    		document.getElementById(idacte).style.backgroundColor = "#eee";
    	};
    	document.getElementById(idacte).onmouseout = function() {
    		document.getElementById(idacte).style.backgroundColor = "#f6f6f6";
    	};
    	this.delete(idacte,type,id);
    	this.getRestItems();
  	}
  }

  submit(idacte, type, id){
  	this.http.get(this.restItemsUrl+"coderacte?idacte="+idacte+"&type="+type+"&id="+id)
  	.subscribe(
  		res => {},
  		err => {
        	alert("Une erreur est survenue lors de l'ajout de l'acte.");
  		}
  	);
  }

  delete(idacte, type, id){
  	this.http.get(this.restItemsUrl+"deleteacte?idacte="+idacte+"&type="+type+"&id="+id)
  	.subscribe(
  		res => {},
  		err => {
        	alert("Une erreur est survenue lors de la suppression de l'acte.");
  		}
  	);
  }

  refreshlist(){
  	for (var item in this.actes){
  		item = this.actes[item];
  		document.getElementById(item['id']).style.backgroundColor = "#3499D9";
  		document.getElementById(item['id']).onmouseover = function() {
    		document.getElementById(item['id']).style.backgroundColor = "#1c72a8";
    	};
    	document.getElementById(item['id']).onmouseout = function() {
    		document.getElementById(item['id']).style.backgroundColor = "#3499D9";
    	};
  	}

  }


}
