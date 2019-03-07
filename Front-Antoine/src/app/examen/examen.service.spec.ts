import { TestBed } from '@angular/core/testing';

import { ExamenService } from './examen.service';

describe('ExamenService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ExamenService = TestBed.get(ExamenService);
    expect(service).toBeTruthy();
  });
});
