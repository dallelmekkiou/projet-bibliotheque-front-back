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

  ngOnInit(): void {
  }

  methodeConnexion(formulaire:any){
    let utilisateur=formulaire.value;
    console.log(utilisateur.nom)
    console.log(utilisateur.motPasse)
    // let utilisateurValide=this.authentificationService.connexion(utilisateur.nom,utilisateur.motPasse);    
    // if (utilisateurValide){ console.log('connexion réussie'); this.messageConnexion=true }
    // else { console.log('erreur de connexion'); this.messageErreur=true}
   let utilisateurs=this.authentificationService.connexion();//recuperer le tableau des utilisateurs du service
   utilisateurs.forEach((u)=>{
        if(u.nom==utilisateur.nom && u.motPasse==utilisateur.motPasse){
          this.estConnecte=true;
          this.utilisateurConnecte=u.nom
          this.role=u.role
          localStorage.setItem('estConnecte',String(this.estConnecte));
          localStorage.setItem('utilisateurConnecte',this.utilisateurConnecte);
          this.authentificationService.logged( this.utilisateurConnecte);
        }
      });
      if (this.estConnecte){ 
        console.log('connexion réussie'); 
        this.messageConnexion=true }

    else { console.log('erreur de connexion'); this.messageErreur=true}
  }

}
