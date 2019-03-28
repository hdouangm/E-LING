import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { FormGroup} from '@angular/forms';
import { FileService } from '../../file/file.service';
import { PosologieService } from '../posologie.service';
import { Posologie } from '../../datamodel/data';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-posologie-detail',
  templateUrl: './posologie-detail.component.html',
  styleUrls: ['./posologie-detail.component.css']
})
export class PosologieDetailComponent implements OnInit {



    public posologie: Posologie;

    @ViewChild('myModallPosologie') openModal: ElementRef;

    registerForm: FormGroup;

  constructor(public posologieService: PosologieService, public route: ActivatedRoute) {
  }

  ngOnInit() {
      this.openModal.nativeElement.click();
      this.posologie = new Posologie();
      // tslint:disable-next-line:radix
      this.posologieService.getPosologieByID(Number.parseInt(this.route.snapshot.paramMap.get('id'))).subscribe(
          res => {this.posologie = res; } );
  }

    cancel() {
      history.back();
    }

}

