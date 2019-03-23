import { Component, OnInit, Input } from '@angular/core';
import { FormGroup} from '@angular/forms';
import { FileService } from '../../file/file.service';
import { ExamenService } from '../examen.service';
import { Examen } from '../../datamodel/data';

@Component({
  selector: 'app-examen-detail',
  templateUrl: './examen-detail.component.html',
  styleUrls: ['./examen-detail.component.css']
})
export class ExamenDetailComponent implements OnInit {

    @Input() examenid: number;

    public examen: Examen;

    public imgURL: string;
    registerForm: FormGroup;

    @Input() id: number;
  constructor(public fileService: FileService, examenService: ExamenService) {
      // this.imgURL = environment.apiUrl + '/upload/examen' + this.examen.id + '/' + this.examen.URLresultats ;
      this.examen = new Examen();
      examenService.getAllExamens().subscribe(res => {
          this.imgURL = this.fileService.getExamResultURL(res[res.length - 1]);
          this.examen = res[res.length - 1];
          // examenService.linkDMP(this.examen.id, 69).subscribe(() => console.log('ok') );
      });

      // examenService.getExamenByID(this.id).subscribe(res => this.examen = res );
  }

  ngOnInit() {
  }

}

