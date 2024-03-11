import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginRequest } from 'src/services/auth/loginRequest';
import { LoginserviceService } from 'src/services/auth/loginservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit{

  loginError:string="";
  loginForm = this.formBuilder.group({
    nombre:['',[Validators.required,Validators.email]],
    contrasenia: ['',Validators.required],
  })

  constructor(private formBuilder:FormBuilder, private router:Router, private loginService: LoginserviceService) { }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  login(){
    console.log(this.loginForm);
    if(this.loginForm.value.nombre != null && this.loginForm.value.contrasenia != null){
      this.loginError="";
      this.loginService.login(this.loginForm.value as LoginRequest).subscribe({
        next: (userData) => {
          console.log(userData);
        },
        error: (errorData) => {
          console.log(errorData);
          this.loginError = errorData;
        },
        complete: () => {
          console.info("Login Completado");
          //this.router.navigateByUrl();
          //this.loginForm.reset();
        }
      })
    }else{
      this.loginForm.markAllAsTouched();
      alert("Error al ingresar los datos");
    }
  }

  get nombre (){
    return this.loginForm.controls.nombre;
  }

  get contrasenia (){
    return this.loginForm.controls.contrasenia;
  }

}
