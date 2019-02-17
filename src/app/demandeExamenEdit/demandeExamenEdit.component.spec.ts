import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeExamenEditComponent } from './demande-examen-edit.component';

describe('DemandeExamenEditComponent', () => {
  let component: DemandeExamenEditComponent;
  let fixture: ComponentFixture<DemandeExamenEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeExamenEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeExamenEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
