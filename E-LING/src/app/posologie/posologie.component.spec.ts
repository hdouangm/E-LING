import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PosologieComponent } from './posologie.component';

describe('PosologieComponent', () => {
  let component: PosologieComponent;
  let fixture: ComponentFixture<PosologieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PosologieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PosologieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
