import { Component, ElementRef, Renderer2 } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css'],
})
export class FooterComponent {

  constructor(private elementRef: ElementRef, private renderer: Renderer2) {}

  /*
  ngOnInit() {
    // Accede al elemento app-footer
    const footerElement = this.elementRef.nativeElement.querySelector('footer');

    // Obtén el valor actual del margen izquierdo
    const currentMarginLeft = footerElement.style.marginLeft;

    // Si el margen izquierdo está vacío o no está definido
    if (currentMarginLeft === "" || currentMarginLeft === "0px") {
      // Establece el margen izquierdo en 282px
      this.renderer.setStyle(footerElement, 'margin-left', '282px');
    }
  }*/
}
