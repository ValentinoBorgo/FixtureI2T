import { TestBed } from '@angular/core/testing';

import { AltaCompetenciaService } from './alta-competencia.service';

describe('AltaCompetenciaService', () => {
  let service: AltaCompetenciaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AltaCompetenciaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
