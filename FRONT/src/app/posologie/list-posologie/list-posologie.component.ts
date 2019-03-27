import { Component, OnInit } from '@angular/core';
import { Posologie } from '../../datamodel/data';
import { ActivatedRoute } from '@angular/router';
import { PosologieService } from '../posologie.service';

@Component({
  selector: 'app-list-posologie',
  templateUrl: './list-posologie.component.html',
  styleUrls: ['./list-posologie.component.css']
})
export class ListPosologieComponent implements OnInit {

    public list: Array<Posologie>;

  constructor(public service: PosologieService, public router: ActivatedRoute) { }

  ngOnInit() {
    this.router.snapshot.paramMap.get('id');
    // tslint:disable-next-line:radix
    this.service.getPosologieByIDDMP(Number.parseInt(this.router.snapshot.paramMap.get('id'))).subscribe(
        (res) => this.list = res.reverse());
    // this.service.getAllPosologies().subscribe((res) => this.list = res);
  }
}
