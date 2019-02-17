import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeExamenListComponent } from './demandeExamenList.component';

describe('DemandeExamenListComponent', () => {
  let component: DemandeExamenListComponent;
  let fixture: ComponentFixture<DemandeExamenListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeExamenListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeExamenListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
