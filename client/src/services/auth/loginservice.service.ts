import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, catchError, delay, map, tap, throwError } from 'rxjs';
import { LoginRequest } from './loginRequest';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  private user:any = "";

  //Es un objeto que mantiene el valor actual y lo emite cuando es necesario
  currentUserLoginOn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  currentUserData: BehaviorSubject<String> =new BehaviorSubject<String>("");

  constructor(private http:HttpClient) { 
    this.currentUserLoginOn = new BehaviorSubject<boolean>(sessionStorage.getItem("access_token")!=null);
    this.currentUserData = new BehaviorSubject<String>(sessionStorage.getItem("access_token") || "");
  }

  login(credentials:LoginRequest):Observable<any>{
    console.log(credentials);
    const options = { withCredentials: true };
    //SOLUCIONAR ESTA PARTE DEL CODIGO
    return this.http.post<any>(environment.urlApi+"users/login?nombre="
    +credentials.nombre+"&contrasenia="+credentials.contrasenia, options).pipe(
      tap( (userData) => {
        console.log(userData);
        sessionStorage.setItem("access_token", userData.access_token);
        this.currentUserData.next(userData.access_token);
        this.currentUserLoginOn.next(true);
      }),
      //El map tranforma los datos
      map((userData) => userData.access_token),
      catchError(this.handleError),
      delay(2000)
    )
  }

  logout():void{
    sessionStorage.removeItem("token");
    this.currentUserLoginOn.next(false);
  }

  get userData():Observable<String>{
    return this.currentUserData.asObservable();
  }

  private handleError(error:HttpErrorResponse){
    if(error.status===0){
      console.error('Se ha producio un error ', error.error);
    }
    else{
      console.error('Backend retornó el código de estado ', error);
    }
    return throwError(()=> new Error('Algo falló. Por favor intente nuevamente.'));
  }

  setUser(user: any){
    this.user = user;
  }

  getUser():any{
    return this.user;
  }

}
