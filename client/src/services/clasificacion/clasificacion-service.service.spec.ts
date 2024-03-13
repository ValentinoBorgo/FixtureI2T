import { TestBed } from '@angular/core/testing';

import { ClasificacionServiceService } from './clasificacion-service.service';

describe('ClasificacionServiceService', () => {
  let service: ClasificacionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClasificacionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
