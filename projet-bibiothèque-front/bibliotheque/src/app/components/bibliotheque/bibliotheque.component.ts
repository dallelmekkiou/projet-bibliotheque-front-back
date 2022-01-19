import { Component, OnInit } from '@angular/core';
import { BibliothequeService } from 'src/app/services/bibliotheque.service';

@Component({
  selector: 'app-bibliotheque',
  templateUrl: './bibliotheque.component.html',
  styleUrls: ['./bibliotheque.component.css']
})
export class BibliothequeComponent implements OnInit {

  constructor(private bibliothequeService: BibliothequeService) { }
  show1=false; 
  show2=false;
 
  listeBibliotheques:any;
  bibliothequeRecupere={
    id:'',
    nom:'',
    description:'',
    image:'',
    adresse:'',
    tel:''
  }

  ngOnInit(): void {
    this.afficherBibliotheques();
  }

  // ********************** CRUD Bibliothèques*******************
  afficherBibliotheques(){
    this.bibliothequeService.getBibliotheques().subscribe(data=>{
      this.listeBibliotheques=data;
     
    })
  }

}
