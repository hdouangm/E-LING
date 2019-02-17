import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeInterventionListComponent } from './demande-intervention-list.component';

describe('DemandeInterventionListComponent', () => {
  let component: DemandeInterventionListComponent;
  let fixture: ComponentFixture<DemandeInterventionListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeInterventionListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeInterventionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
