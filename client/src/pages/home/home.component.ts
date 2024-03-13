import { Component } from '@angular/core';
import { ClasificacionServiceService } from 'src/services/clasificacion/clasificacion-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(private clasificacionService : ClasificacionServiceService){}

  cla(){
    this.clasificacionService.getClasification().subscribe(
      clasificacion => {
        console.log(clasificacion);
      },
      error => {
        console.log("Error al obtener la clasificación : ",error);
      }
    )
  }

}
