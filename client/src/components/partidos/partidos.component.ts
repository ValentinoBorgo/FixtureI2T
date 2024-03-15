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
  
  competenciasMap: { [key: number]: string } = {};

  constructor(
    private competenciaService: CompetenciaServiceService,
    private partidosServices : PartidosServiceService
  ){}

  ngOnInit(){
    this.matches();
  }

  matches(){
    this.partidosServices.getPartidos().subscribe(
      partidos => {
        this.partidos = partidos;
        this.cargarNombreCompetencias();
        console.log(partidos)
      },
      error => {
        console.log("Error al obtener los equipos : ",error);
      }
    )
  }

  cargarNombreCompetencias() {
    // Iteramos sobre cada partido
    for (let partido of this.partidos) {
      // Obtenemos el nombre de la competencia para este partido
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
}

