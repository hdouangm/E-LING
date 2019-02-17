import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeInterventionEditComponent } from './demande-intervention-edit.component';

describe('DemandeInterventionEditComponent', () => {
  let component: DemandeInterventionEditComponent;
  let fixture: ComponentFixture<DemandeInterventionEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeInterventionEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeInterventionEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
