import { Component, OnInit, Input } from '@angular/core';
import { Examen } from 'src/app/datamodel/dataModel';
import { FormGroup} from '@angular/forms';
import { FileService } from '../../file/file.service';
import { ExamenService } from '../examen.service';

@Component({
  selector: 'app-examen-detail',
  templateUrl: './examen-detail.component.html',
  styleUrls: ['./examen-detail.component.css']
})
export class ExamenDetailComponent implements OnInit {

    @Input() examen: Examen;

    public imgURL: string;
    registerForm: FormGroup;
  constructor(public fileService: FileService, examenService: ExamenService) {
      // this.imgURL = environment.apiUrl + '/upload/examen' + this.examen.id + '/' + this.examen.URLresultats ;
      this.examen = new Examen();
      examenService.getAllExamens().subscribe(res => this.imgURL = this.fileService.getExamResultURL(res[res.length - 1]));
  }

  ngOnInit() {
  }

}

