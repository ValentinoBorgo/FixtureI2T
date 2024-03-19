import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from 'src/components/login/login.component';
import { LoginserviceService } from 'src/services/auth/loginservice.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

  nombre:any = "";


  constructor(private router:Router, private user:LoginserviceService){}

  activeNavItem:string | null = null;

  ngDoCheck(): void{
    this.nombre = this.user.getUser();
    console.log(this.nombre);
  }

  active(NavItem:string){
    this.activeNavItem = NavItem;
    console.log(this.activeNavItem);
  }

  logout(){
    sessionStorage.removeItem("access_token");
    this.router.navigateByUrl('/login');
  }

}
