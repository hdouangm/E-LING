import { Component, OnInit, Input } from '@angular/core';
import { InterventionService } from '../intervention.service';
import { Intervention } from 'src/app/datamodel/data';
import { RouterLink, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-listintervention',
  templateUrl: './list-intervention.component.html',
  styleUrls: ['./list-intervention.component.css']
})
export class ListinterventionComponent implements OnInit {

    public list: Array<Intervention>;

  constructor(public service: InterventionService, public router: ActivatedRoute) { }

  ngOnInit() {
    this.router.snapshot.paramMap.get('id');
    // tslint:disable-next-line:radix
    this.service.getInterventionByIDDMP(Number.parseInt(this.router.snapshot.paramMap.get('id'))).subscribe((res) => this.list = res);
    // this.service.getAllInterventions().subscribe((res) => this.list = res);
  }

}
