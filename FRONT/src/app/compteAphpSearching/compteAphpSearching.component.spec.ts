import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompteAphpSearchingComponent } from './compteAphpSearching.component';

describe('CompteAphpSearchingComponent', () => {
  let component: CompteAphpSearchingComponent;
  let fixture: ComponentFixture<CompteAphpSearchingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompteAphpSearchingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompteAphpSearchingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
