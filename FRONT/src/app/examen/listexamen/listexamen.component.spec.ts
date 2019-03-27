import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListexamenComponent } from './listexamen.component';

describe('ListexamenComponent', () => {
  let component: ListexamenComponent;
  let fixture: ComponentFixture<ListexamenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListexamenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListexamenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
