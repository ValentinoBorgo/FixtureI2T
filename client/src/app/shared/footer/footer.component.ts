import { Component, ElementRef, Renderer2 } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Route, Router } from '@angular/router';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css'],
})
export class FooterComponent {

  constructor(private route:Router, private elementRef: ElementRef, private renderer: Renderer2){}

  ngOnInit(){
    this.route.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        const currentPageUrl = this.route.url;
        console.log(currentPageUrl);
        // Ahora puedes usar currentPageUrl como desees, por ejemplo, para aplicar estilos
        if (currentPageUrl === '/login') {
          const footerElement = this.elementRef.nativeElement.querySelector('footer');
          this.renderer.setStyle(footerElement, 'margin-left', '0');
        }else{
          const footerElement = this.elementRef.nativeElement.querySelector('footer');
          this.renderer.setStyle(footerElement, 'margin-left', '282');
        }
      }
    });
  }
  }
