import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from 'src/app/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-dmp',
  templateUrl: './list-dmp.component.html',
  styleUrls: ['./list-dmp.component.css']
})
export class ListDmpComponent implements OnInit {
  dmps: Array<object> = [];
  searchForm: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder, private  apiService: ApiService) { }

  ngOnInit() {
    this.searchForm = this.fb.group({
      key: ['', [Validators.required]]
    });
    // this.getDMP();
  }

  getDMP() {
    this.apiService.getDMP(this.getValue(`key`)).subscribe((data: Array<object>) => {
      // this.dmps.push(data);
      console.log(data);
  });
  }

  // convenience getter for easy access to form fields
  get f() { return this.searchForm.controls; }

  onSubmit() {
      this.submitted = true;
      // stop here if form is invalid
      if (this.searchForm.invalid) {
        return;
      }
      this.apiService.getDMP(this.getValue('key'))
        .subscribe((reponse: object) => {
            this.dmps.push(reponse);
      });
  }

  getValue(id: string) {
    return this.searchForm.get(`${id}`).value;
  }

}
