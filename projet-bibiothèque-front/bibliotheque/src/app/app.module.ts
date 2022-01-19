import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BibliothequeComponent } from './components/bibliotheque/bibliotheque.component';
import { GestionBibliothequeComponent } from './components/gestion-bibliotheque/gestion-bibliotheque.component';
import { HomeComponent } from './components/home/home.component';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { LivreComponent } from './components/livre/livre.component';



@NgModule({
  declarations: [
    AppComponent,
    BibliothequeComponent,
    GestionBibliothequeComponent,
    HomeComponent,
    LivreComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModalModule,
    BrowserAnimationsModule,

    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
