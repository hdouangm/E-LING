import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { FormGroup} from '@angular/forms';
import { FileService } from '../../file/file.service';
import { InterventionService } from '../intervention.service';
import { Intervention } from '../../datamodel/data';
import { ActivatedRoute } from '@angular/router';

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

    @ViewChild('myModallIntervention') openModal: ElementRef;
    public id: number;
  constructor(private route: ActivatedRoute, public fileService: FileService, public interventionService: InterventionService) {
      // this.imgURL = environment.apiUrl + '/upload/intervention' + this.intervention.id + '/' + this.intervention.URLresultats ;
    /*  interventionService.getAllInterventions().subscribe(res => {
          this.imgURL = this.fileService.getExamResultURL(res[res.length - 1]);
          this.intervention = res[res.length - 1];
          // interventionService.linkDMP(this.intervention.id, 69).subscribe(() => console.log('ok') );
      });*/

      // interventionService.getInterventionByID(this.id).subscribe(res => this.intervention = res );
  }

  ngOnInit() {
        this.openModal.nativeElement.click();
        console.log('ok');
        console.log(this.route.snapshot.paramMap.get('id'));
        // tslint:disable-next-line:radix
        this.interventionService.getInterventionByID(Number.parseInt(this.route.snapshot.paramMap.get('id'))).subscribe((res) => {
            this.intervention = res;
            this.imgURL = this.fileService.getInterventionResultURL(res);
        });
  }


}

