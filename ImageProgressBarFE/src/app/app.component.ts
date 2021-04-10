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
  noimagen: string = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQoTAA74ouC9U_W1kaNxVkJaiMdvOi9GlKfSNGhxVOR-4GRP19i2PoqAQ_Rh1y2lul&usqp=CAU';

  constructor(private imageServer: ImageserverService, private sanitizer: DomSanitizer){

  }

  ngOnInit(){

    // this.imageServer.getData().subscribe((res: any)=>{
    // let objectURL = 'data:image/png;base64,' + res.image;
    // this.imagen = this.sanitizer.bypassSecurityTrustUrl(objectURL);
    // })
  }

  getImage(ancho: any, alto: any, porcentaje: any){
    this.imageServer.getData(ancho,alto,porcentaje).subscribe((res: any)=>{
    let objectURL = 'data:image/png;base64,' + res.image;
    this.imagen = this.sanitizer.bypassSecurityTrustUrl(objectURL);
    })
  }
}
