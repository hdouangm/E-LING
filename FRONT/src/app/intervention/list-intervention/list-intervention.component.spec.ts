import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListInterventionComponent } from './list-intervention.component';

describe('ListInterventionComponent', () => {
  let component: ListInterventionComponent;
  let fixture: ComponentFixture<ListInterventionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListInterventionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListInterventionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
