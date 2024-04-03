import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompetenciaComponent } from 'src/components/competencia/competencia.component';
import { LoginComponent } from 'src/components/login/login.component';
import { NavComponent } from './shared/nav/nav.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from 'src/pages/home/home.component';
import { ClasificacionComponent } from 'src/components/clasificacion/clasificacion.component';
import { EquiposComponent } from 'src/components/equipos/equipos.component';
import { PartidosComponent } from 'src/components/partidos/partidos.component';
import { RegisterComponent } from 'src/components/register/register.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatListModule } from '@angular/material/list';
import {MatIconModule} from '@angular/material/icon';
import { AltaCompetenciaComponent } from 'src/components/alta-competencia/alta-competencia.component';


//https://material.angular.io/components/form-field/examples
//DOC DE MATERIAL

@NgModule({
  declarations: [
    AppComponent,
    CompetenciaComponent,
    LoginComponent,
    NavComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    ClasificacionComponent,
    EquiposComponent,
    PartidosComponent,
    RegisterComponent,
    AltaCompetenciaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatCardModule,
    MatProgressSpinnerModule,
    MatToolbarModule,
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
