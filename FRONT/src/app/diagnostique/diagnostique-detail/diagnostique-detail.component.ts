import { Component, OnInit, Input } from '@angular/core';
import { FormGroup} from '@angular/forms';
import { FileService } from '../../file/file.service';
import { DiagnostiqueService } from '../diagnostique.service';
import { Diagnostique } from '../../datamodel/data';

@Component({
  selector: 'app-diagnostique-detail',
  templateUrl: './diagnostique-detail.component.html',
  styleUrls: ['./diagnostique-detail.component.css']
})
export class DiagnostiqueDetailComponent implements OnInit {

    @Input() diagnostiqueid: number;

    public diagnostique: Diagnostique;

    registerForm: FormGroup;

    @Input() id: number;
  constructor(public fileService: FileService, diagnostiqueService: DiagnostiqueService) {
      this.diagnostique = new Diagnostique();
      diagnostiqueService.getAllDiagnostiques().subscribe(res => {
          this.diagnostique = res[res.length - 1];
          // diagnostiqueService.linkDMP(this.diagnostique.id, 69).subscribe(() => console.log('ok') );
      });

      // diagnostiqueService.getDiagnostiqueByID(this.id).subscribe(res => this.diagnostique = res );
  }

  ngOnInit() {
  }

}

