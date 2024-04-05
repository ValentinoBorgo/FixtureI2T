import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Params } from './paramsCompetence';
import { Observable, catchError, mergeMap, of, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AltaCompetenciaService {

  constructor(private http: HttpClient) {}

  private getToken(): HttpHeaders {
    const token = sessionStorage.getItem('access_token');
    return new HttpHeaders().set('Authorization', `Bearer ${token}`);
  }

  private getUser(): Observable<any> {
    const headers = this.getToken();
    return this.http.get<any>(environment.urlApi + 'users/getByName/' + sessionStorage.getItem('user'), { headers }).pipe(
      catchError(error => {
        console.error('Error al obtener el ID del usuario:', error);
        return throwError(error);
      }),
      mergeMap(response => {
        console.log(response);
        if (response) {
          return of(response); // Suponiendo que el ID del usuario está en una propiedad llamada 'id'
        } else {
          return throwError('No se pudo obtener el ID del usuario.');
        }
      })
    );
  }

  obtainDateTimeLocal() {
    const fechaHoraActual = new Date();
    const fechaHoraActualFormateada = fechaHoraActual.toISOString().slice(0, 16); // Formato YYYY-MM-DDTHH:MM
    return fechaHoraActualFormateada;
  }

  addCompetence(parametros: Params): Observable<any> {
    return this.getUser().pipe(
      mergeMap(user => {
        const headers = this.getToken();

        const competenciaData = {
          nombre: parametros.nombre,
          fecha_baja: parametros.fecha_baja,
          fecha_creacion: parametros.fecha_creacion,
          fecha_inicio: this.obtainDateTimeLocal(),
          usuario: user
        };

        //Solo queda solucioanr esto, no tomo el id_usuario
        console.log("USUARIO ID : "+competenciaData.usuario);

        return this.http.post<any>(environment.urlApi + 'competencias/crear',competenciaData, { headers }).pipe(
          catchError(error => {
            console.log(competenciaData);
            console.error('Error al agregar competencia:', error);
            return throwError(error);
          })
        );
      })
    );
  }
}