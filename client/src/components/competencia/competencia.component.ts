import { Component } from '@angular/core';
import { CompetenciaServiceService } from 'src/services/competencia/competencia-service.service';

@Component({
  selector: 'app-competencia',
  templateUrl: './competencia.component.html',
  styleUrls: ['./competencia.component.css']
})

export class CompetenciaComponent {
  competencias: any[] = [];
  constructor(private competenciaService : CompetenciaServiceService){}

  ngOnInit(){
    this.competitions();
  }

  competitions(){
    this.competenciaService.getCompetencia().subscribe(
      competencias => {
        this.competencias = competencias;
        this.competenciaService.setCompetencias(competencias);
        console.log(competencias);
      },
      error => {
        console.log("Error al obtener los equipos : ",error);
      }
    )
  }
}
