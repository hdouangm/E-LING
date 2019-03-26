import { Component, OnInit, Input } from '@angular/core';
import { ExamenService } from '../examen.service';
import { Examen } from 'src/app/datamodel/data';

@Component({
  selector: 'app-listexamen',
  templateUrl: './listexamen.component.html',
  styleUrls: ['./listexamen.component.css']
})
export class ListexamenComponent implements OnInit {

    public list: Array<Examen>;

  constructor(public service: ExamenService) { }

  ngOnInit() {
    this.service.getAllExamens().subscribe((res) => this.list = res);
  }

}
