import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from 'src/pages/home/home.component';
import { LoginComponent } from 'src/components/login/login.component';
import { ClasificacionComponent } from 'src/components/clasificacion/clasificacion.component';
import { EquiposComponent } from 'src/components/equipos/equipos.component';
import { PartidosComponent } from 'src/components/partidos/partidos.component';
import { CompetenciaComponent } from 'src/components/competencia/competencia.component';
import { RegisterComponent } from 'src/components/register/register.component';
import { AltaCompetenciaComponent } from 'src/components/alta-competencia/alta-competencia.component';

const routes: Routes = [
  {path : '', redirectTo:'/login', pathMatch:'full'},
  {path : 'login', component : LoginComponent},
  {path : 'log/home', component : HomeComponent},
  {path : 'log/clasification', component : ClasificacionComponent},
  {path : 'log/teams', component : EquiposComponent},
  {path : 'log/matches', component : PartidosComponent},
  {path : 'log/competition', component : CompetenciaComponent},
  {path : 'register', component : RegisterComponent},
  {path : 'log/add_competence', component : AltaCompetenciaComponent}
  /*
  {path : 'competencias'},
  {path : 'partidos'},
  {path : 'equipos'},
  */
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
