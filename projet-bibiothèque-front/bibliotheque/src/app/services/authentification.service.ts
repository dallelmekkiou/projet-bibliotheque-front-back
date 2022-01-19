import { analytics } from '@angular-devkit/core';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  public users=[
    {nom:'dallel',motPasse:'dddd'},
    {nom:'yesmine',motPasse:'yyyy'},
    {nom:'mohamed',motPasse:'mmmm'},
    {nom:'anis',motPasse:'aaaa'}

  ];
  user:any;
  valide=false;
  constructor() { }

 verifAuthentification(nom:any,motPasse:any){
   for (this.user in this.users){
     if(this.user.nom==nom){
       if(this.user.motPasse==motPasse){this.valide=true}else{return "Mot de passe incorrect !"}
     }else{ return " Nom incorrect !"}
   }
   return this.valide;

 }

}
