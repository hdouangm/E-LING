import { TestBed } from '@angular/core/testing';

import { DiagnostiqueService } from './diagnostique.service';

describe('DiagnostiqueService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DiagnostiqueService = TestBed.get(DiagnostiqueService);
    expect(service).toBeTruthy();
  });
});
