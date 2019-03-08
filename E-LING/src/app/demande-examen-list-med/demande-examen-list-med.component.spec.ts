import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeExamenListMedComponent } from './demande-examen-list-med.component';

describe('DemandeExamenListMedComponent', () => {
  let component: DemandeExamenListMedComponent;
  let fixture: ComponentFixture<DemandeExamenListMedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeExamenListMedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeExamenListMedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
