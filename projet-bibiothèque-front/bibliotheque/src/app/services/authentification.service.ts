import { analytics } from '@angular-devkit/core';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  public utilisateurs=[
    {nom:'dallel',motPasse:'dddd'},
    {nom:'yesmine',motPasse:'yyyy'},
    {nom:'mohamed',motPasse:'mmmm'},
    {nom:'anis',motPasse:'aaaa'}
  ];
  utilisateurConnecte:any;
  estConnecte=false;
  constructor() { }

 connexion(nom:any,motPasse:any){
  this.utilisateurs.forEach((u)=>{
    if(u.nom==nom && u.motPasse==motPasse){
      this.estConnecte=true;
      // this.utilisateurConnecte=u.nom
      // localStorage.setItem('estConnecte',String(this.estConnecte));
      // localStorage.setItem('utilisateurConnecte',this.utilisateurConnecte);

    }
  });
  return this.estConnecte
 }

}
