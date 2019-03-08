import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDmpComponent } from './list-dmp.component';

describe('ListDmpComponent', () => {
  let component: ListDmpComponent;
  let fixture: ComponentFixture<ListDmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListDmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListDmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
