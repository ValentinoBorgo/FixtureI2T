import { TestBed } from '@angular/core/testing';

import { ParticipanteServiceService } from './participante-service.service';

describe('ParticipanteServiceService', () => {
  let service: ParticipanteServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ParticipanteServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
