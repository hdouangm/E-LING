import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccederDmpComponent } from './acceder-dmp.component';

describe('AccederDmpComponent', () => {
  let component: AccederDmpComponent;
  let fixture: ComponentFixture<AccederDmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccederDmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccederDmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
