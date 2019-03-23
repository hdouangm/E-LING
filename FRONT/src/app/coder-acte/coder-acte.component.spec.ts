import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoderActeComponent } from './coder-acte.component';

describe('CoderActeComponent', () => {
  let component: CoderActeComponent;
  let fixture: ComponentFixture<CoderActeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoderActeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoderActeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
