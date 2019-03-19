import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeInterventionListLabComponent } from './demande-intervention-list-lab.component';

describe('DemandeInterventionListLabComponent', () => {
  let component: DemandeInterventionListLabComponent;
  let fixture: ComponentFixture<DemandeInterventionListLabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeInterventionListLabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeInterventionListLabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
