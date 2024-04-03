import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CompetenciaServiceService } from 'src/services/competencia/competencia-service.service';

@Component({
  selector: 'app-competencia',
  templateUrl: './competencia.component.html',
  styleUrls: ['./competencia.component.css']
})

export class CompetenciaComponent {
  competencias: any[] = [];
  constructor(private competenciaService : CompetenciaServiceService, private router : Router){}

  ngOnInit(){
    this.competitions();
  }

  moveToAddCompetencies(){
    
    this.router.navigateByUrl("/log/add_competence");
  }

  competitions(){
    this.competenciaService.getCompetencia().subscribe(
      competencias => {
        this.competencias = competencias;
        this.competenciaService.setCompetencias(competencias);
      },
      error => {
        console.log("Error al obtener los equipos : ",error);
      }
    )
  }
}
