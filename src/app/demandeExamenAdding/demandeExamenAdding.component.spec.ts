import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeExamenAddingComponent } from './demande-examen-adding.component';

describe('DemandeExamenAddingComponent', () => {
  let component: DemandeExamenAddingComponent;
  let fixture: ComponentFixture<DemandeExamenAddingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeExamenAddingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeExamenAddingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
