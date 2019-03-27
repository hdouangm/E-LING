import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPosologieComponent } from './list-posologie.component';

describe('ListPosologieComponent', () => {
  let component: ListPosologieComponent;
  let fixture: ComponentFixture<ListPosologieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListPosologieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListPosologieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
