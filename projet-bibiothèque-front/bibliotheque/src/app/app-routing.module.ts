import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BibliothequeComponent } from './components/bibliotheque/bibliotheque.component';
import { GestionBibliothequeComponent } from './components/gestion-bibliotheque/gestion-bibliotheque.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {path:'',component: HomeComponent},
  {path:'bibliotheque',component: BibliothequeComponent},
  {path:'gestionBibliotheque',component: GestionBibliothequeComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
