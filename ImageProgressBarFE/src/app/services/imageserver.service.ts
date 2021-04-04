import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ImageserverService {

  constructor(private http: HttpClient) { }

  getData(){
    // return 'https://cdn.eso.org/images/thumb700x/eso1907a.jpg';
    return this.http.get('http://localhost:8080/imageprogressbar/download');
  }
}
