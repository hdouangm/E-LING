import { Component, OnInit, Input } from '@angular/core';
import { Examen } from 'src/app/datamodel/examen';
import { environment } from '../../../environments/environment.prod';
import { FormGroup} from '@angular/forms';
import { FileService } from '../../file.service';

@Component({
  selector: 'app-examen-detail',
  templateUrl: './examen-detail.component.html',
  styleUrls: ['./examen-detail.component.css']
})
export class ExamenDetailComponent implements OnInit {

    @Input() examen: Examen;

    public imgURL: string;
    registerForm: FormGroup;
  constructor(fileService: FileService) {
      // this.imgURL = environment.apiUrl + '/upload/examen' + this.examen.id + '/' + this.examen.URLresultats ;
      this.examen = new Examen();
      this.imgURL = fileService.getExamResultURL(0);
      this.examen.id = 0;
  }

  ngOnInit() {
  }

}

