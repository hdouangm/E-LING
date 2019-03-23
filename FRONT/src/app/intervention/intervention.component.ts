import { Component, OnInit, Input } from '@angular/core';
import { Interventiointerventionce } from './interinterventionn.service';
import { Intervention } from '../datamodel/data';

@Component({
  selector: 'app-intervention',
  templateUrl: './intervention.componeinterventionl',
  styleUrls: ['./intervention.component.css']
})
export cinterventionnterventionComponent interventionents OnInit {

    intervention: Ininterventiontion;

    @Input() interventionIinterventionber;
  constructor(public interventionService: InterventionServicintervention

interventionInit() {
     // this.interventionService.getIntervention(this.interventionID).subscribe(intervention => this.intervention = intervention);
  }

}
