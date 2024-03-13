import { Component } from '@angular/core';
import { EquiposService } from 'src/services/equipos/equipos.service';

@Component({
  selector: 'app-equipos',
  templateUrl: './equipos.component.html',
  styleUrls: ['./equipos.component.css']
})
export class EquiposComponent {

  equipos: any[] = [];

  constructor(private equiposServices : EquiposService){}

  ngOnInit(){
    this.teams();
  }

  teams(){
    this.equiposServices.getEquipos().subscribe(
      equipos => {
        this.equipos = equipos;
      },
      error => {
        console.log("Error al obtener los equipos : ",error);
      }
    )
  }

}
