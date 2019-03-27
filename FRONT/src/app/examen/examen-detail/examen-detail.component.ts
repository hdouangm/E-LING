import { Component, OnInit, Input, ElementRef, ViewChild } from '@angular/core';
import { FormGroup} from '@angular/forms';
import { FileService } from '../../file/file.service';
import { ExamenService } from '../examen.service';
import { Examen } from '../../datamodel/data';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';

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

    @ViewChild('myModallExamen') openModal: ElementRef;
    public id: number;
  constructor(private route: ActivatedRoute, public fileService: FileService, public examenService: ExamenService) {
      // this.imgURL = environment.apiUrl + '/upload/examen' + this.examen.id + '/' + this.examen.URLresultats ;
    /*  examenService.getAllExamens().subscribe(res => {
          this.imgURL = this.fileService.getExamResultURL(res[res.length - 1]);
          this.examen = res[res.length - 1];
          // examenService.linkDMP(this.examen.id, 69).subscribe(() => console.log('ok') );
      });*/

      // examenService.getExamenByID(this.id).subscribe(res => this.examen = res );
  }

  ngOnInit() {
        this.openModal.nativeElement.click();
        console.log('ok');
        console.log(this.route.snapshot.paramMap.get('id'));
        // tslint:disable-next-line:radix
        this.examenService.getExamenByID(Number.parseInt(this.route.snapshot.paramMap.get('id'))).subscribe((res) => {
            this.examen = res;
            this.imgURL = this.fileService.getExamResultURL(res);
        });
  }


}

