import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeInterventionAddingComponent } from './demande-intervention-adding.component';

describe('DemandeInterventionAddingComponent', () => {
  let component: DemandeInterventionAddingComponent;
  let fixture: ComponentFixture<DemandeInterventionAddingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeInterventionAddingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeInterventionAddingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
