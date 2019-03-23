import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PosologieDetailComponent } from './posologie-detail.component';

describe('PosologieDetailComponent', () => {
  let component: PosologieDetailComponent;
  let fixture: ComponentFixture<PosologieDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PosologieDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PosologieDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
