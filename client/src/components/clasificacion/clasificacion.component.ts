import { Component } from '@angular/core';
import { ClasificacionServiceService } from 'src/services/clasificacion/clasificacion-service.service';

@Component({
  selector: 'app-clasificacion',
  templateUrl: './clasificacion.component.html',
  styleUrls: ['./clasificacion.component.css']
})

export class ClasificacionComponent {

  clasificacion: any[] = [];

  constructor(private clasificacionService : ClasificacionServiceService){}

  ngOnInit(){
    this.cla();
  }

  cla(){
    this.clasificacionService.getClasification().subscribe(
      clasificacion => {
        this.clasificacion = clasificacion;
      },
      error => {
        console.log("Error al obtener la clasificación : ",error);
      }
    )
  }

}
