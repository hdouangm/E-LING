import {Component, ElementRef, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { environment } from './../../environments/environment';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-list-patient',
  templateUrl: './list-patient.component.html',
  styleUrls: ['./list-patient.component.css']
})
export class ListPatientComponent implements OnInit {
  searchText: string;
  searchNom: string;
  searchPrenom: string;
  searchAge: string;
  searchPays: string;
  searchGenre: string;
  searchSs: string;
  restItems: any;
  storageLogin: any;
  storageNiveau: any;
  storageId:any;
  restItemsUrl =  environment.apiUrl + '/secretairemedicale/patients';
  constructor(private elementRef: ElementRef,private  apiService: ApiService, private http: HttpClient) {
    this.elementRef.nativeElement.style.setProperty('--mar-za', '50%');

  }

  ngOnInit() {
    this.getRestItems();


  }


  // Read all REST Items
  getRestItems(): void {
    this.restItemsServiceGetRestItems()
      .subscribe(
        restItems => {
          this.restItems = restItems;
          this.storageLogin = localStorage.getItem("login");
          this.storageNiveau = localStorage.getItem("niveau");
          this.storageId = localStorage.getItem("id");
          console.log(this.restItems);
        }
      );
  }

  // Rest Items Service: Read all REST Items
  restItemsServiceGetRestItems() {
    return this.http
      .get<any[]>(this.restItemsUrl)
      .pipe(map(data => data));
  }

}
