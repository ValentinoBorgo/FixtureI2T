import { Component } from '@angular/core';
import { ClasificacionServiceService } from 'src/services/clasificacion/clasificacion-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(private clasificacionService : ClasificacionServiceService){}

}
