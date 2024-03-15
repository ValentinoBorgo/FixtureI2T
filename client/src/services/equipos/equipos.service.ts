import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EquiposService {

  currentUserData: BehaviorSubject<String> =new BehaviorSubject<String>("");
  equipos: any[] = [];

  constructor(private http:HttpClient) { 
    this.currentUserData = new BehaviorSubject<String>(sessionStorage.getItem("access_token") || "");
  }

  getToken():HttpHeaders{
    const token = sessionStorage.getItem('access_token');
    const headers = new HttpHeaders();
    return headers.set('Authorization', `Bearer ${token}`);
  }

  getEquipos():Observable<any>{

    const headers = this.getToken();

    return this.http.get<any>(environment.urlApi+"participantes/get", { headers })

  }
  setEquipos(equipos: any[]): void{
    this.equipos= equipos;
  }
  getEquiposById(id : number): Observable<any>{
    const headers = this.getToken();
    return this.http.get<any>(environment.urlApi + "participantes/" + id, { headers });
  }
}
