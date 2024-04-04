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

  private getUserId(): Observable<number> {
    const headers = this.getToken();
    return this.http.get<any>(environment.urlApi + 'users/getIdByName/' + sessionStorage.getItem('user'), { headers }).pipe(
      catchError(error => {
        console.error('Error al obtener el ID del usuario:', error);
        return throwError(error);
      }),
      mergeMap(response => {
        if (response && response.id) {
          return of(response.id); // Suponiendo que el ID del usuario está en una propiedad llamada 'id'
        } else {
          return throwError('No se pudo obtener el ID del usuario.');
        }
      })
    );
  }

  addCompetence(parametros: Params): Observable<any> {
    return this.getUserId().pipe(
      mergeMap(userId => {
        const headers = this.getToken();
        const competenciaData = {
          userId: userId,
          nombre: parametros.nombre,
          fecha_baja: parametros.fecha_baja,
          fecha_creacion: parametros.fecha_creacion
        };

        return this.http.post<any>(environment.urlApi + 'api/competencias/crear', competenciaData, { headers }).pipe(
          catchError(error => {
            console.error('Error al agregar competencia:', error);
            return throwError(error);
          })
        );
      })
    );
  }
}