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
  // estConnecte=false;
  // role:any;

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

 logged( utilisateurConnecte:any){
   this.utilisateurConnecte=utilisateurConnecte
 }

}
