import { TestBed } from '@angular/core/testing';

import { PosologieService } from './posologie.service';

describe('PosologieService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PosologieService = TestBed.get(PosologieService);
    expect(service).toBeTruthy();
  });
});
