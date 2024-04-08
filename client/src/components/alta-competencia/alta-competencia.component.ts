import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AltaCompetenciaService } from 'src/services/altaCompetencia/alta-competencia.service';
import { Params } from 'src/services/altaCompetencia/paramsCompetence';

@Component({
  selector: 'app-alta-competencia',
  templateUrl: './alta-competencia.component.html',
  styleUrls: ['./alta-competencia.component.css']
})

export class AltaCompetenciaComponent implements OnInit{

  constructor(private formBuilder:FormBuilder, private altaCompetenciaService:AltaCompetenciaService, private router:Router){
    
  }

  msgError : boolean | null | undefined;


  registerCompetenceForm = this.formBuilder.group({
    nombre:['',Validators.required],
    fecha_baja: ['',Validators.required],
    fecha_creacion: ['',Validators.required]
  })



  ngOnInit(): void {
    this.msgError = null;
  }

  parseDate(data:any) {
    const date = new Date(data);
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0'); // Sumamos 1 porque los meses van de 0 a 11
    const day = String(date.getDate()).padStart(2, '0');
    const hours = String(date.getHours()).padStart(2, '0');
    const minutes = String(date.getMinutes()).padStart(2, '0');
    const seconds = String(date.getMinutes()).padStart(2, '0');

    return `${year}-${month}-${day}T${hours}:${minutes}:${seconds}`;
}

  registerCompetence(){
    console.log(this.registerCompetenceForm.valid);
    if(this.registerCompetenceForm.valid){
      //Parseo de datos a formato DateTimeLocal
      this.registerCompetenceForm.value.fecha_baja = this.parseDate(this.registerCompetenceForm.value.fecha_baja);
      this.registerCompetenceForm.value.fecha_creacion = this.parseDate(this.registerCompetenceForm.value.fecha_creacion);
      this.altaCompetenciaService.addCompetence(this.registerCompetenceForm.value as Params).subscribe({

        next : (data) => {
          console.log(data);
        },

        error : (error) => {
          this.msgError = false;
          console.log("ERROR EN HTML : "+ error);
        },
        complete : () => {   
          console.log("EXITOS");
          this.msgError = true;
          this.registerCompetenceForm.reset();
        }
      })
    }else if(!this.registerCompetenceForm.valid){
      this.msgError = false;
      console.log("ERROR");
    }

  }


  moveToMain(){
    this.router.navigateByUrl("/log/home");
  }

}
