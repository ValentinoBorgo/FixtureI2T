import { Component, ElementRef, Renderer2, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})

export class AppComponent {
  title = 'FIXTURE';

  @ViewChild('app-footer') appFooter!: ElementRef;

  constructor(private renderer: Renderer2, private router:Router) {}

  viewRoute(): boolean {
    // Verifica si la URL actual coincide con la ruta específica
  const currentUrl = this.router.url;
  return currentUrl === '/login' || currentUrl === '/register';
  }

}
