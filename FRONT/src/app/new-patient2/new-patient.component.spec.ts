import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewPatientDeuxComponent} from './new-patient.component';

describe('NewPatientDeuxComponent', () => {
  let component: NewPatientDeuxComponent;
  let fixture: ComponentFixture<NewPatientDeuxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewPatientDeuxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewPatientDeuxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
