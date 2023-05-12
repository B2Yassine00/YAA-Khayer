import { TestBed } from '@angular/core/testing';

import { DonnationService } from './donnation.service';

describe('DonnationService', () => {
  let service: DonnationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DonnationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
