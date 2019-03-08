import { TestBed } from '@angular/core/testing';

import { InterventionService } from './intervention.service';

describe('InterventionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: InterventionService = TestBed.get(InterventionService);
    expect(service).toBeTruthy();
  });
});
