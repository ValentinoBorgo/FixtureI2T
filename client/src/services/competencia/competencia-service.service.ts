import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, map } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CompetenciaServiceService {

  currentUserData: BehaviorSubject<String> =new BehaviorSubject<String>("");

  constructor(private http:HttpClient) { 
    this.currentUserData = new BehaviorSubject<String>(sessionStorage.getItem("access_token") || "");
  }

  getToken():HttpHeaders{
    const token = sessionStorage.getItem('access_token');
    const headers = new HttpHeaders();
    return headers.set('Authorization', `Bearer ${token}`);
  }

  getCompetencia():Observable<any>{
    const headers = this.getToken();

    return this.http.get<any>(environment.urlApi+"competencias/get", { headers })
}
  getNombreIdCompetencia(): Observable<{ id: string, nombre: string }[]> {
  const headers = this.getToken();
  return this.http.get<any[]>(environment.urlApi + "competencias/get", { headers }).pipe(
      map(competencias => competencias.map(({ id, nombre }) => ({ id, nombre })))
  );
}
}
