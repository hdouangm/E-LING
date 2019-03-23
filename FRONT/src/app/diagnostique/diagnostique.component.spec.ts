import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiagnostiqueComponent } from './diagnostique.component';

describe('DiagnostiqueComponent', () => {
  let component: DiagnostiqueComponent;
  let fixture: ComponentFixture<DiagnostiqueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiagnostiqueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiagnostiqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
