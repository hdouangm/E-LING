import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InterventionDetailComponent } from './intervention-detail.component';

describe('InterventionDetailComponent', () => {
  let component: InterventionDetailComponent;
  let fixture: ComponentFixture<InterventionDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InterventionDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InterventionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
