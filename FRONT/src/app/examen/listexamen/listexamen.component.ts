import { Component, OnInit, Input } from '@angular/core';
import { ExamenService } from '../examen.service';
import { Examen } from 'src/app/datamodel/data';
import { RouterLink, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-listexamen',
  templateUrl: './listexamen.component.html',
  styleUrls: ['./listexamen.component.css']
})
export class ListexamenComponent implements OnInit {

    public list: Array<Examen>;

  constructor(public service: ExamenService, public router: ActivatedRoute) { }

  ngOnInit() {
    this.router.snapshot.paramMap.get('id');
    // tslint:disable-next-line:radix
    this.service.getExamenByIDDMP(Number.parseInt(this.router.snapshot.paramMap.get('id'))).subscribe((res) => this.list = res.reverse());
    // this.service.getAllExamens().subscribe((res) => this.list = res);
  }

}
