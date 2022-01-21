import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationService } from './services/authentification.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(public authentificationService:AuthentificationService,private router:Router) {
   }

  ngOnInit(): void {
    let estConnecte:any;
    let utilisateurConnecte:any;
    let nomUtilisateurConnecte:any;
    let admin:any;
    let role:any;

    estConnecte=localStorage.getItem('estConnecte');
    utilisateurConnecte=localStorage.getItem('utilisateurConnecte');
    nomUtilisateurConnecte=localStorage.getItem('nomUtilisateurConnecte');
    admin=localStorage.getItem('admin');
    role=localStorage.getItem('role');
   
    if (estConnecte!= "true" ||!utilisateurConnecte)
       this.router.navigate(['authentification'])
    else 
       this.authentificationService.setUtilisateurConnecteFromLocalStorage( utilisateurConnecte, nomUtilisateurConnecte,role,admin);
 
  }
  
  
}
