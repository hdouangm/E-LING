import { Component, OnInit, Input } from '@angular/core';
import { Intervention } from 'src/app/datamodel/intervention';
import { FormGroup} from '@angular/forms';
import { FileService } from '../../file/file.service';

@Component({
  selector: 'app-intervention-detail',
  templateUrl: './intervention-detail.component.html',
  styleUrls: ['./intervention-detail.component.css']
})
export class InterventionDetailComponent implements OnInit {

    @Input() intervention: Intervention;

    public imgURL: string;
    registerForm: FormGroup;
  constructor(public fileService: FileService) {
      // this.imgURL = environment.apiUrl + '/upload/intervention' + this.intervention.id + '/' + this.intervention.URLresultats ;
      this.intervention = new Intervention();
      this.intervention.id = 1;
      this.imgURL = this.fileService.getInterventionResultURL(this.intervention);
  }

  ngOnInit() {
  }

}

