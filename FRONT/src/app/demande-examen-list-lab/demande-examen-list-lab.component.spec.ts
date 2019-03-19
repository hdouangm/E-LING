import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeExamenListLabComponent } from './demande-examen-list-lab.component';

describe('DemandeExamenListLabComponent', () => {
  let component: DemandeExamenListLabComponent;
  let fixture: ComponentFixture<DemandeExamenListLabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeExamenListLabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeExamenListLabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
