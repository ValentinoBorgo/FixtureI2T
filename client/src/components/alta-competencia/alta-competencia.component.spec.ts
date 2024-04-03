import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AltaCompetenciaComponent } from './alta-competencia.component';

describe('AltaCompetenciaComponent', () => {
  let component: AltaCompetenciaComponent;
  let fixture: ComponentFixture<AltaCompetenciaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AltaCompetenciaComponent]
    });
    fixture = TestBed.createComponent(AltaCompetenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
