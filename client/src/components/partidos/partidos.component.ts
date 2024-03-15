import { Component } from '@angular/core';
import { CompetenciaServiceService } from 'src/services/competencia/competencia-service.service';
import { EquiposService } from 'src/services/equipos/equipos.service';
import { PartidosServiceService } from 'src/services/partidos/partidos-service.service';
@Component({
  selector: 'app-partidos',
  templateUrl: './partidos.component.html',
  styleUrls: ['./partidos.component.css']
})
export class PartidosComponent {
  partidos: any[] = [];
  

  constructor(
    private competenciaService: CompetenciaServiceService,
    private partidosServices : PartidosServiceService,
    private equiposServices : EquiposService
  ){}

  ngOnInit(){
    this.matches();
  }

  matches(){
    this.partidosServices.getPartidos().subscribe(
      partidos => {
        this.partidos = partidos;
        this.cargarNombreCompetencias();
        this.cargarNombreEquipos();
        console.log(partidos)
      },
      error => {
        console.log("Error al obtener los equipos : ",error);
      }
    )
  }

  cargarNombreCompetencias() {
    // Itero sobre cada partido
    for (let partido of this.partidos) {
      // Obtiene el nombre de la competencia para este partido
      this.competenciaService.getCompetenciaById(partido.idCompetencia).subscribe(
        (competencia : any) => {
          partido.nombreCompetencia = competencia.nombre;
        },
        (error : any) => {
          console.log("Error al obtener la competencia: ", error);
        }
      );
    }
  }
  cargarNombreEquipos(){
    //itero sobre cada partido
    for(let partido of this.partidos){
      //Obtiene el nombre de los equipos para cada partido
      this.equiposServices.getEquiposById(partido.idLocal).subscribe(
        (equipos : any) => {
          partido.nombreEquipoLocal = equipos.nombre;
        },
        (error : any) => {
          console.log("Error al obtener el nombre del equipo: ", error);
        }
      );
      this.equiposServices.getEquiposById(partido.idVisitante).subscribe(
        (equipos : any) => {;
          partido.nombreEquipoVisitante = equipos.nombre;
        },
        (error : any) => {
          console.log("Error al obtener el nombre del equipo: ", error);
        }
      );
    }
  }
}

