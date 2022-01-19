import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {

  constructor(private authentificationService:AuthentificationService) { }

  ngOnInit(): void {
  }

  connexion(formulaire:any){
    let data=formulaire.value;
    console.log(data.nom)
    console.log(data.motPasse)
    this.authentificationService.verifAuthentification(data.nom,data.motPasse);
    

  }

}
