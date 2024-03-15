import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {


  constructor(private router:Router){}

  activeNavItem:string | null = null;

  active(NavItem:string){
    this.activeNavItem = NavItem;
    console.log(this.activeNavItem);
  }

  logout(){
    sessionStorage.removeItem("access_token");
    this.router.navigateByUrl('/login');
  }

}
