import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { FormGroup} from '@angular/forms';
import { FileService } from '../../file/file.service';
import { DiagnostiqueService } from '../diagnostique.service';
import { Diagnostique } from '../../datamodel/data';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-diagnostique-detail',
  templateUrl: './diagnostique-detail.component.html',
  styleUrls: ['./diagnostique-detail.component.css']
})
export class DiagnostiqueDetailComponent implements OnInit {


    public diagnostique: Diagnostique;

    @ViewChild('myModallDiagnostique') openModal: ElementRef;

    registerForm: FormGroup;

  constructor(public diagnostiqueService: DiagnostiqueService, public route: ActivatedRoute) {
  }

  ngOnInit() {
      this.openModal.nativeElement.click();
      this.diagnostique = new Diagnostique();
      // tslint:disable-next-line:radix
      this.diagnostiqueService.getDiagnostiqueByID(Number.parseInt(this.route.snapshot.paramMap.get('id'))).subscribe(
          res => {this.diagnostique = res; } );
  }

    cancel() {
      history.back();
    }

}

