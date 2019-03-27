import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDiagnostiqueComponent } from './list-diagnostique.component';

describe('ListDiagnostiqueComponent', () => {
  let component: ListDiagnostiqueComponent;
  let fixture: ComponentFixture<ListDiagnostiqueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListDiagnostiqueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListDiagnostiqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
