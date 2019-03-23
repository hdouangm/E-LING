import { Component, OnInit, Input } from '@angular/core';
import { FormGroup} from '@angular/forms';
import { FileService } from '../../file/file.service';
import { InterventionService } from '../intervention.service';
import { Intervention } from '../../datamodel/data';

@Component({
  selector: 'app-intervention-detail',
  templateUrl: './intervention-detail.component.html',
  styleUrls: ['./intervention-detail.component.css']
})
export class InterventionDetailComponent implements OnInit {

    @Input() interventionid: number;

    public intervention: Intervention;

    public imgURL: string;
    registerForm: FormGroup;

    @Input() id: number;
  constructor(public fileService: FileService, interventionService: InterventionService) {
      // this.imgURL = environment.apiUrl + '/upload/intervention' + this.intervention.id + '/' + this.intervention.URLresultats ;
      this.intervention = new Intervention();
      interventionService.getAllInterventions().subscribe(res => {
          this.imgURL = this.fileService.getInterventionResultURL(res[res.length - 1]);
          this.intervention = res[res.length - 1];
          // interventionService.linkDMP(this.intervention.id, 69).subscribe(() => console.log('ok') );
      });

      // interventionService.getInterventionByID(this.id).subscribe(res => this.intervention = res );
  }

  ngOnInit() {
  }

}

