import { Component } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

  activeNavItem:string | null = null;

  active(NavItem:string){
    this.activeNavItem = NavItem;
    console.log(this.activeNavItem);
  }

}
