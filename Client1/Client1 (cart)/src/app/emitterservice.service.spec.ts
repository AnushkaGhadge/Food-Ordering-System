import { TestBed } from '@angular/core/testing';

import { EmitterserviceService } from './emitterservice.service';

describe('EmitterserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EmitterserviceService = TestBed.get(EmitterserviceService);
    expect(service).toBeTruthy();
  });
});
