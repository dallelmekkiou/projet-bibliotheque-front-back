import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {

  constructor(private authentificationService:AuthentificationService) { }
 
  messageConnexion=false;
  messageErreur=false;

  ngOnInit(): void {
  }

  methodeConnexion(formulaire:any){
    let utilisateur=formulaire.value;
    console.log(utilisateur.nom)
    console.log(utilisateur.motPasse)
    let utilisateurValide=this.authentificationService.connexion(utilisateur.nom,utilisateur.motPasse);
    if (utilisateurValide){ console.log('connexion réussie'); this.messageConnexion=true }
    else { console.log('erreur de connexion'); this.messageErreur=true}

  }

}
