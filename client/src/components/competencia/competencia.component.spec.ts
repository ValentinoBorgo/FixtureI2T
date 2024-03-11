import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompetenciaComponent } from './competencia.component';

describe('CompetenciaComponent', () => {
  let component: CompetenciaComponent;
  let fixture: ComponentFixture<CompetenciaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CompetenciaComponent]
    });
    fixture = TestBed.createComponent(CompetenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
