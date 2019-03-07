import { Component, OnInit, Input } from '@angular/core';
import { InterventionService } from './intervention.service';
import { Intervention } from 'src/app/datamodel/intervention';

@Component({
  selector: 'app-intervention',
  templateUrl: './intervention.component.html',
  styleUrls: ['./intervention.component.css']
})
export class InterventionComponent implements OnInit {

    intervention: Intervention;

    @Input() interventionID: number;
  constructor(public interventionService: InterventionService) { }

  ngOnInit() {
     // this.interventionService.getIntervention(this.interventionID).subscribe(intervention => this.intervention = intervention);
  }

}
