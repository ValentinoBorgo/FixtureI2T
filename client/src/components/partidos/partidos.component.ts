import { Component } from '@angular/core';
import { EquiposService } from 'src/services/equipos/equipos.service';
import { PartidosServiceService } from 'src/services/partidos/partidos-service.service';
@Component({
  selector: 'app-partidos',
  templateUrl: './partidos.component.html',
  styleUrls: ['./partidos.component.css']
})
export class PartidosComponent {
  partidos: any[] = [];

  constructor(private partidosServices : PartidosServiceService){}

  ngOnInit(){
    this.teams();
  }

  teams(){
    this.partidosServices.getPartidos().subscribe(
      partidos => {
        this.partidos = partidos;
      },
      error => {
        console.log("Error al obtener los equipos : ",error);
      }
    )
  }
}

