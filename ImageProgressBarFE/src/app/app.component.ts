import { Component } from '@angular/core';
import { ImageserverService } from './services/imageserver.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  imagen: any;

  constructor(private imageServer: ImageserverService, private sanitizer: DomSanitizer){

  }

  ngOnInit(){


    // this.imagen = this.imageServer.getData();


    this.imageServer.getData().subscribe((res: any)=>{
      // this.imagen = res;
      let objectURL = 'data:image/png;base64,' + res.image;

         this.imagen = this.sanitizer.bypassSecurityTrustUrl(objectURL);
    })
  }
}
