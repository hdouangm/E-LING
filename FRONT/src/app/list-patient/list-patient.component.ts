import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { environment } from './../../environments/environment';

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
  restItems: any;
  restItemsUrl =  environment.apiUrl + '/secretairemedicale/patients';

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.getRestItems();


  }

  // Read all REST Items
  getRestItems(): void {
    this.restItemsServiceGetRestItems()
      .subscribe(
        restItems => {
          this.restItems = restItems;
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
