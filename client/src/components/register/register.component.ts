import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { RegisterService } from 'src/services/register/register.service';
import { registerBody } from 'src/services/register/registerBody';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})

export class RegisterComponent implements OnInit{

  msgError : boolean | null | undefined;

  registerForm = this.formBuilder.group({
    nombre:['',Validators.required],
    apellido: ['',Validators.required],
    mail : ['',Validators.email],
    contrasenia : ['',Validators.required],
    fecha_baja: ['',Validators.required],
    autoridades: <any>[] 
  })

  ngOnInit(): void {
    this.msgError = null;
   console.log("REGISTRO");
  }

  constructor(private router:Router,private formBuilder:FormBuilder, private registerService:RegisterService){}


  register(){
    console.log(this.registerForm.valid);
    if(this.registerForm.valid){
      this.registerForm.value.fecha_baja = this.registerForm.value.fecha_baja?.toString();
      this.registerService.regiser(this.registerForm.value as registerBody).subscribe({
        error : (error) => {
          this.msgError = false;
          console.log("ERROR EN HTML : "+ error);
        },
        complete : () => {
          this.msgError = true;
          console.log("EXITOS");
          this.registerForm.reset();
        }
      })
    }else if(!this.registerForm.valid){
      console.log("ERROR");
      this.msgError = false;
    }
  }
  moveToLogin(){
    this.router.navigateByUrl("/login");
  }
}
