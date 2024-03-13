import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class PartidosServiceService {

  currentUserData: BehaviorSubject<String> =new BehaviorSubject<String>("");

  constructor(private http:HttpClient) { 
    this.currentUserData = new BehaviorSubject<String>(sessionStorage.getItem("access_token") || "");
  }

  getToken():HttpHeaders{
    const token = sessionStorage.getItem('access_token');
    const headers = new HttpHeaders();
    return headers.set('Authorization', `Bearer ${token}`);
  }

  getPartidos():Observable<any>{

    const headers = this.getToken();

    return this.http.get<any>(environment.urlApi+"partido/get", { headers })
}
}
