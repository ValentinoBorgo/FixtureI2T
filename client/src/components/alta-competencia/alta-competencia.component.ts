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


  registerCompetenceForm = this.formBuilder.group({
    nombre:['',Validators.required],
    fecha_baja: ['',Validators.required],
    fecha_creacion: ['',Validators.required]
  })



  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  registerCompetence(){
    console.log(this.registerCompetenceForm.valid);
    if(this.registerCompetenceForm.valid){
      this.registerCompetenceForm.value.fecha_baja = this.registerCompetenceForm.value.fecha_baja?.toString();
      this.registerCompetenceForm.value.fecha_baja = this.registerCompetenceForm.value.fecha_creacion?.toString();
      this.altaCompetenciaService.addCompetence(this.registerCompetenceForm.value as Params).subscribe({

        next : (data) => {
          console.log(data);
        },

        error : (error) => {
          console.log("ERROR EN HTML : "+ error.toString());
        },
        complete : () => {   
          console.log("EXITOS");
          this.registerCompetenceForm.reset();
        }
      })
    }else if(!this.registerCompetenceForm.valid){
      console.log("ERROR");
      
    }

  }


  moveToMain(){
    this.router.navigateByUrl("/log/home");
  }







}
