import { Component, OnInit, Input } from '@angular/core';
import { DiagnostiqueService } from '../diagnostique.service';
import { Diagnostique } from 'src/app/datamodel/data';
import { RouterLink, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-listdiagnostique',
  templateUrl: './list-diagnostique.component.html',
  styleUrls: ['./list-diagnostique.component.css']
})
export class ListdiagnostiqueComponent implements OnInit {

    public list: Array<Diagnostique>;

  constructor(public service: DiagnostiqueService, public router: ActivatedRoute) { }

  ngOnInit() {
    this.router.snapshot.paramMap.get('id');
    // tslint:disable-next-line:radix
    this.service.getDiagnostiqueByIDDMP(Number.parseInt(this.router.snapshot.paramMap.get('id'))).subscribe(
        (res) => this.list = res.reverse());
    // this.service.getAllDiagnostiques().subscribe((res) => this.list = res);
  }

}
