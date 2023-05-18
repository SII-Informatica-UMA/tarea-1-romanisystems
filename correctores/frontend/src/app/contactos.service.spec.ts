import { TestBed } from '@angular/core/testing';

import { CorrectoresService } from './correctores.service';

describe('CorrectoresService', () => {
  let service: CorrectoresService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CorrectoresService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
