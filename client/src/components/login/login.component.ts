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

  msgError: boolean = false;

  loginError:string="";
  loginForm = this.formBuilder.group({
    nombre:['',Validators.required],
    contrasenia: ['',Validators.required],
  })

  constructor(private formBuilder:FormBuilder, private router:Router, private loginService: LoginserviceService) { }

  ngOnInit(): void {
    
  }

  moveToRegister(){
    this.router.navigateByUrl("/register");
  }

  login(){
    console.log(this.loginForm);
    if(this.loginForm.valid){
      this.loginError="";
      this.loginService.setUser(this.loginForm.value.nombre);
      this.loginService.login(this.loginForm.value as LoginRequest).subscribe({
        next: (userData) => {
          console.log(userData);
        },
        error: (errorData) => {
          this.msgError = true;
          console.log(errorData);
          this.loginError = errorData;
        },
        complete: () => {
          console.info("Login Completado");
          this.router.navigateByUrl('/log/home');
          this.loginForm.reset();
        }
      })
    }else{
      this.msgError = true;
      this.loginForm.markAllAsTouched();
      alert("Ingrese los datos de los 2 campos");
    }
  }

  get nombre (){
    return this.loginForm.controls.nombre;
  }

  get contrasenia (){
    return this.loginForm.controls.contrasenia;
  }

}
