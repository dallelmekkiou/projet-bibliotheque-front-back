import { analytics } from '@angular-devkit/core';
import { Injectable } from '@angular/core';

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

  constructor() { }

 connexion(){
//   this.utilisateurs.forEach((u)=>{
//     if(u.nom==nom && u.motPasse==motPasse){
//       this.estConnecte=true;
//       this.utilisateurConnecte=u.nom
//       this.role=u.role
//       localStorage.setItem('estConnecte',String(this.estConnecte));
//       localStorage.setItem('utilisateurConnecte',this.utilisateurConnecte);
      
//     }
//   });
//   return this.estConnecte
return this.utilisateurs
 }

 loggedIn( utilisateurConnecte:any){
   this.utilisateurConnecte=utilisateurConnecte
   this.nomUtilisateurConnecte=utilisateurConnecte.nom 
   this.estConnecte=true;
 }

 isAdmin(){
   this.admin=true;
   return this.admin;
 }

}
