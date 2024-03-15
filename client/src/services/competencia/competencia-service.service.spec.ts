import { TestBed } from '@angular/core/testing';

import { CompetenciaServiceService } from './competencia-service.service';

describe('CompetenciaServiceService', () => {
  let service: CompetenciaServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompetenciaServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
