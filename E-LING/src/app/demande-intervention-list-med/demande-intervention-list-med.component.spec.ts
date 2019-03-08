import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeInterventionListMedComponent } from './demande-intervention-list-med.component';

describe('DemandeInterventionListMedComponent', () => {
  let component: DemandeInterventionListMedComponent;
  let fixture: ComponentFixture<DemandeInterventionListMedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeInterventionListMedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeInterventionListMedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
