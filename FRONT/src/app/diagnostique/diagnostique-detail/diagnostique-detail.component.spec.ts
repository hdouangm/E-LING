import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiagnostiqueDetailComponent } from './diagnostique-detail.component';

describe('DiagnostiqueDetailComponent', () => {
  let component: DiagnostiqueDetailComponent;
  let fixture: ComponentFixture<DiagnostiqueDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiagnostiqueDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiagnostiqueDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
