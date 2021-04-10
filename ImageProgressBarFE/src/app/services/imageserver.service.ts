import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ImageserverService {

  constructor(private http: HttpClient) { }

  getData(ancho: any, alto: any, porcentaje: any){
    // return 'https://cdn.eso.org/images/thumb700x/eso1907a.jpg';
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    let params = new HttpParams().set("ancho",ancho).set("alto", alto).set("porcentaje",porcentaje);
    return this.http.get('http://inserlan-pc:8080/imageprogressbar/get', { headers: headers, params: params });
  }
}
