import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BibliothequeService {

  url="http://localhost:8088/bibliotheques";
  url2="http://localhost:8088/bibliotheques/search/";
  constructor(private http:HttpClient) { }

 getBibliotheques(){
    return this.http.get(this.url)
  }
 
 createBibliotheque(biblio:any){
  return this.http.post(this.url,biblio)
 }
 
 deleteBibliotheque(id:any){
    return this.http.delete(this.url+'/'+id)
  }
 
 updateBibliotheque(biblio:any){
 
   return this.http.put(this.url+'/'+biblio.id,biblio)
  }
 
  getLivres(idBiblio:any){
    return this.http.get("http://localhost:8088/bibliotheques/"+idBiblio+"/livres")
  }

  rechercheBibliotheques(cherche:any){//première methode
    return this.http.get(this.url2+"byName?name="+cherche)
  }

  // rechercheBibliotheques(cherche:any){//deuxième methode
  //   return this.http.get('http://localhost:8088/rechercherBibliotheque/'+cherche)
  // }
  
  rechercheBibliothequesNbrAdherent(min:any,max:any){//première methode
    return this.http.get(this.url2+"byNbrAdherentBetween?"+"min="+min+"&max="+max)
  }

  // rechercheBibliothequesNbrAdherent(min:any,max:any){//deuxième methode
  //   return this.http.get('http://localhost:8088/rechercherBibliothequeNbrAdherent/'+ min + ',' + max)
  // }

}
