import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Params } from './paramsCompetence';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class AltaCompetenciaService {

  constructor(private http:HttpClient) { 
  

  }


  getToken():HttpHeaders{
    const token = sessionStorage.getItem('access_token');
    const headers = new HttpHeaders();
    return headers.set('Authorization', `Bearer ${token}`);
  }

  addCompetence(parametros:Params):Observable<any>{
      console.log(parametros);
      const headers = this.getToken();
      const idNombreUsuario = this.http.get<any>(environment.urlApi+"users/getIdByName/"
      +sessionStorage.getItem("user"),{ headers });

      console.log(idNombreUsuario);
      return idNombreUsuario;

      
  }

}
