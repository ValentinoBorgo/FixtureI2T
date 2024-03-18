import { Component, ElementRef, Renderer2, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})

export class AppComponent {
  title = 'FIXTURE';

  //ARREGLAR ESTO

  @ViewChild('app-footer') appFooter!: ElementRef;

  constructor(private renderer: Renderer2, private router:Router) {}

  /*
  ngAfterViewInit() {
    // Acceder al elemento app-footer
    const footerElement = this.appFooter.nativeElement;

    // Acceder a un elemento HTML dentro de app-footer (por ejemplo, un div con la clase "footer-content")
    const innerElement = footerElement.querySelector('.footer');

    console.log(innerElement);

    // Realizar operaciones en el elemento innerElement, como ajustar el estilo
    this.renderer.setStyle(innerElement, 'margin-left', '0px');
  }
  */

  viewRoute(): boolean {
    // Verifica si la URL actual coincide con la ruta específica
    return this.router.url === '/login';
  }

}
