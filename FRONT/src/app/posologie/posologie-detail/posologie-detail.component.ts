import { Component, OnInit, Input } from '@angular/core';
import { FormGroup} from '@angular/forms';
import { FileService } from '../../file/file.service';
import { PosologieService } from '../posologie.service';
import { Posologie } from '../../datamodel/data';

@Component({
  selector: 'app-posologie-detail',
  templateUrl: './posologie-detail.component.html',
  styleUrls: ['./posologie-detail.component.css']
})
export class PosologieDetailComponent implements OnInit {

    @Input() posologieid: number;

    public posologie: Posologie;

    registerForm: FormGroup;

    @Input() id: number;
  constructor(public fileService: FileService, posologieService: PosologieService) {
      this.posologie = new Posologie();
      posologieService.getAllPosologies().subscribe(res => {
          this.posologie = res[res.length - 1];
          // posologieService.linkDMP(this.posologie.id, 69).subscribe(() => console.log('ok') );
      });

      // posologieService.getPosologieByID(this.id).subscribe(res => this.posologie = res );
  }

  ngOnInit() {
  }

}

