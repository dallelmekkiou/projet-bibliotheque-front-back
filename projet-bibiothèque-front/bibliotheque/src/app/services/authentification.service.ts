import { analytics } from '@angular-devkit/core';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  public utilisateurs=[
    {nom:'dallel',motPasse:'dddd',role:'admin'},
    {nom:'yesmine',motPasse:'yyyy',role:'user'},
    {nom:'mohamed',motPasse:'mmmm',role:'admin'},
    {nom:'anis',motPasse:'aaaa',role:'user'}
  ];
  utilisateurConnecte:any;
  nomUtilisateurConnecte:any;
  admin=false;
  estConnecte=false;

  constructor(private router:Router) { }

 login(){
   return this.utilisateurs
 }

 loggedIn( utilisateurConnecte:any){
   this.utilisateurConnecte=utilisateurConnecte
   this.nomUtilisateurConnecte=utilisateurConnecte.nom 
   this.estConnecte=true;
 }

 isAdmin(){
   this.admin=true;
   this.router.navigate(['gestionBibliotheque'])
   return this.admin;
   
 }

 logOut(){
  this.estConnecte=false;
  this.nomUtilisateurConnecte=undefined;
  this.utilisateurConnecte=undefined;
  localStorage.removeItem('estConnecte');
  localStorage.removeItem('utilisateurConnecte');
 }

}
