import { Component, OnInit } from '@angular/core';
import { BibliothequeService } from 'src/app/services/bibliotheque.service';
import {ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-gestion-bibliotheque',
  templateUrl: './gestion-bibliotheque.component.html',
  styleUrls: ['./gestion-bibliotheque.component.css']
})
export class GestionBibliothequeComponent implements OnInit {
 

  constructor(private bibliothequeService: BibliothequeService) { }

  id=0;
  isActive=false;
  listeBibliotheques:any;
  listeLivres:any;
  biblio:any;
  recherche:any;
  listeTrouve:any;
  show1=false; 
  show2=false;
  showLivres=false;
  message=false;
  bibliothequeRecupere={
    id:'',
    nom:'',
    description:'',
    image:'',
    adresse:'',
    tel:''
  }

  ngOnInit(): void {
    this.afficherBibliotheques()

  }


   // ********************** CRUD Bibliothèques*******************
   afficherBibliotheques(){
    this.bibliothequeService.getBibliotheques().subscribe(data=>{
      this.listeBibliotheques=data;
    })
  }

  afficherFormAjout(){
    this.show1=true
  }

  ajouterBibliotheque(bibliotheque:any){
    let data=bibliotheque.value;
    this.bibliothequeService.createBibliotheque(data).subscribe(reponse=>{
      console.log("bibliotheque ajouté avec succès !")
      this.afficherBibliotheques()
    })
  }

  modifierBibliotheque(bibliotheque: any) {
    this.show2=true
    this.bibliothequeRecupere = bibliotheque; // affecter la valeur de emp a l'objet produit déclaré en haut
  }

  enregistrerModificationBibliotheque(){
    this.bibliothequeService.updateBibliotheque(this.bibliothequeRecupere).subscribe(reponse=>{
      this.afficherBibliotheques()
    })
  }
  
  supprimerBibliotheque(id:any){
    this.bibliothequeService.deleteBibliotheque(id).subscribe(reponse => {
      console.log('supprimé de la base de données!');
      console.log(id);
      this.afficherBibliotheques()
    })
  }

  // *************************CRUD Livres************************************
  afficherLivres(idBiblio:any){
    this.id=idBiblio;
    this.bibliothequeService.getLivres(idBiblio).subscribe(data=>{ 
      this.listeLivres=data;
      this.showLivres=true;
    }, error=>{console.log(error)},)
  }
  
  chercherBibliothequeMotCle() {
   if (this.recherche && this.recherche.trim() != '') {
        this.bibliothequeService.rechercheBibliotheques(this.recherche).subscribe(data => {
        this.listeBibliotheques = data;
        console.log(data);
        console.log(this.listeBibliotheques._embedded.bibliotheques);
        this.listeTrouve = this.listeBibliotheques._embedded.bibliotheques
        console.log(this.listeTrouve.length)
        if (this.listeTrouve.length > 0) {
        
        }
        else {
          console.log("nontrouvé!")
          this.message=true;
          }
      })
    }else{this.ngOnInit();} 
  }
  chercherBibliothequeNbrAdherent(formulaire:any) {
    let data=formulaire.value
    this.bibliothequeService.rechercheBibliothequesNbrAdherent(data.min,data.max).subscribe(data => {
      this.listeBibliotheques = data;
      console.log(this.listeBibliotheques._embedded.bibliotheques);
      this.listeTrouve = this.listeBibliotheques._embedded.bibliotheques
      console.log(this.listeTrouve.length)
      if (this.listeTrouve.length > 0) {
      }
      else {
        console.log("nontrouvé!")
        this.message=true;
        }
    })
}




}
