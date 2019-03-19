import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierProfilComponent } from './modifier-profil.component';

describe('ModifierProfilComponent', () => {
  let component: ModifierProfilComponent;
  let fixture: ComponentFixture<ModifierProfilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifierProfilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifierProfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
