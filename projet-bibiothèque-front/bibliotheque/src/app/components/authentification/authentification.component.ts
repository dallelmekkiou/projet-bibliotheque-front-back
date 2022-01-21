import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {

  constructor(public authentificationService:AuthentificationService) { }
 
  messageConnexion=false;
  messageErreur=false;
  utilisateurConnecte:any;
  estConnecte=false;
  role:any;
  admin=false;
  ngOnInit(): void {
  }

  connexion(formulaire:any){
    let utilisateur=formulaire.value;  
   let utilisateurs=this.authentificationService.login();//recuperer le tableau des utilisateurs du service
   utilisateurs.forEach((u)=>{
        if(u.nom==utilisateur.nom && u.motPasse==utilisateur.motPasse){
          this.utilisateurConnecte=u.nom
          this.role=u.role
          this.estConnecte=true
          this.authentificationService.loggedIn(u);
         if (this.role=='admin'){
           this.authentificationService.isAdmin();}
         }
      });
      if (this.estConnecte){ 
        console.log('connexion réussie'); 
        this.messageConnexion=true }

    else { console.log('erreur de connexion'); this.messageErreur=true}
  }

  deconnexion(){
   this.authentificationService.logOut();
  }

}
