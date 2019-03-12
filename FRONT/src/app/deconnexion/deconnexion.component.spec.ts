import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeconnexionComponent } from './deconnexion.component';

describe('DeconnexionComponent', () => {
  let component: DeconnexionComponent;
  let fixture: ComponentFixture<DeconnexionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeconnexionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeconnexionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
