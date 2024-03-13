import { TestBed } from '@angular/core/testing';

import { PartidosServiceService } from './partidos-service.service';

describe('PartidosServiceService', () => {
  let service: PartidosServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PartidosServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
