import { analytics } from '@angular-devkit/core';
import { HttpClient } from '@angular/common/http';
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
  role:any;

  constructor(private router:Router,private http:HttpClient) { 

  }  


 login(){
   return this.utilisateurs
 }

 loggedIn( utilisateurConnecte:any){
   this.utilisateurConnecte=utilisateurConnecte
   this.nomUtilisateurConnecte=utilisateurConnecte.nom 
   this.estConnecte=true;
   this.role=utilisateurConnecte.role
   localStorage.setItem('estConnecte',String(this.estConnecte));
   localStorage.setItem('utilisateurConnecte',this.utilisateurConnecte);
   localStorage.setItem('nomUtilisateurConnecte',this.nomUtilisateurConnecte);
   localStorage.setItem('role',this.role);

 }

 isAdmin(){
   this.admin=true;
   this.router.navigate(['gestionBibliotheque'])
   localStorage.setItem('admin',String(this.admin));
   return this.admin;  
 }

 logOut(){
  this.estConnecte=false;
  this.nomUtilisateurConnecte=undefined;
  this.utilisateurConnecte=undefined;
  this.admin=false;
  localStorage.removeItem('estConnecte');
  localStorage.removeItem('utilisateurConnecte');
  localStorage.removeItem('nomUtilisateurConnecte');
  localStorage.removeItem('admin');
  localStorage.removeItem('role');
  this.router.navigate(['home'])
 }

setUtilisateurConnecteFromLocalStorage(utilisateurConnecte:any,nomUtilisateurConnecte: any,role:any,admin:any) {
  this.utilisateurConnecte=utilisateurConnecte;
  this.estConnecte=true;
  this.nomUtilisateurConnecte=nomUtilisateurConnecte;
  this.role=role;
  this.admin=admin;
}

}
