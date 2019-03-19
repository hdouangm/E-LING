import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompteAphpAddingComponent } from './compteAphpAdding.component';

describe('CompteAphpAddingComponent', () => {
  let component: CompteAphpAddingComponent;
  let fixture: ComponentFixture<CompteAphpAddingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompteAphpAddingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompteAphpAddingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
