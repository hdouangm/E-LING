import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';


import DataSource from 'devextreme/data/data_source';
import CustomStore from 'devextreme/data/custom_store';
import { ApiService } from 'src/app/api.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-agenda',
  templateUrl: './agenda.component.html',
  styleUrls: ['./agenda.component.css']
})
export class AgendaComponent implements OnInit {


  compte:any;
  dataSource: any;
  currentDate: Date = new Date();
  url: string;
  constructor(private  apiService: ApiService, private router: Router, private activateRoute: ActivatedRoute, private http: HttpClient) {




  }
  getCalendar(){
    this.apiService.calendar(localStorage.getItem('user')).subscribe((response:object) => {
      this.compte = response;
      this.url = this.compte.calendarLink;

      this.dataSource = new DataSource({
        store: new CustomStore({
          load: (options) => this.getData(options, { showDeleted: false })
        })
      });
    });

  }

  ngOnInit() {
    this.getCalendar();
  }
  private getData(options: any, requestOptions: any) {
    let PUBLIC_KEY = 'AIzaSyBS1w7nxQmZ9w83WUr1_zbdY9Ht-70IBjg';
    let dataUrl = [ 'https://www.googleapis.com/calendar/v3/calendars/',
      this.url, '/events?key=', PUBLIC_KEY].join('');

    return this.http.get(dataUrl, requestOptions).toPromise().then((data: any) => data.items);
  }

}
