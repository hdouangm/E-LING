import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompteAphpListComponent } from './compteAphpList.component';

describe('CompteAphpListComponent', () => {
  let component: CompteAphpListComponent;
  let fixture: ComponentFixture<CompteAphpListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompteAphpListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompteAphpListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
