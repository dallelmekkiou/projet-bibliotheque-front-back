package com.example.demo.web;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.LivreRepository;
import com.example.demo.entities.Bibliotheque;
import com.example.demo.entities.Livre;

import net.bytebuddy.utility.RandomString;

@RestController
public class LivreController {
	
	@Autowired
	private LivreRepository lRepository;
	
	//Get une livre
    @RequestMapping(value="/getLivre/{id}", method= RequestMethod.GET)  
	public Livre getLivre(@PathVariable Long id){
	        return lRepository.findById(id).orElse(null);  
	    }
    
	//Get les livres
    @RequestMapping(value="/getLivres", method= RequestMethod.GET)  
	public List<Livre> getLivres(){
	        return lRepository.findAll();  
	    }
    
    //Add livre
    @RequestMapping(value="/addlivre", method=RequestMethod.POST)
	public Livre addLivre(@RequestBody Livre l) {
    	return lRepository.save(l);	
	}

	//Edit
	@RequestMapping(value="/editlivre/{id}", method=RequestMethod.PUT)
	public Livre editLivre(@PathVariable Long id, @RequestBody Livre l) {
		if (lRepository.findById(id).isPresent()) {
		    l.setId(id);
		    return lRepository.save(l);
	    }else {
		return l;
	    }
	}
	

	//Edit un seul attrilut
	@RequestMapping(value="/patchLivre/{id}",method=RequestMethod.PATCH)
	public Livre patchLivre(@PathVariable Long id, @RequestBody Map<String, Object> changes) {
        Livre l = lRepository.findById(id).get();
		changes.forEach(
                (change, value) -> {
                    switch (change){
                        case "nom": l.setTitre((String) value); break;
                        case "description": l.setDescription((String) value); break;
                        case "bibliotheques": l.setBibliotheque((Bibliotheque) value); break;
                    }
                });
		
		return lRepository.save(l);
	}
	
	//Delete
	@RequestMapping(value="/deleteLivre/{id}", method=RequestMethod.DELETE)
	public Boolean deleteLivre(@PathVariable Long id) {
		lRepository.deleteById(id);
		return true;
	}
	
	//add livre aléatoire
	@PostMapping(value="addLivreAleatoire/{nlr}")
	public Boolean addLivreAleatoire(@PathVariable int nlr){
	Random random = new Random();
	int min=5;int max=50;
	for (int i=0; i<=nlr;i++) {
	   lRepository.save(new Livre(null,RandomString.make(100),RandomString.make(100),random.nextInt(min,max),null));	
	}
	 return true;
	}
	
	//rechercher livres par mot clé
	@RequestMapping(value="/rechercherLivre/{motCle}", method= RequestMethod.GET)  
	public List<Livre> getLivre(@PathVariable String motCle){
	        return lRepository.findByTitreContains(motCle);  
	    }
	
	//rechercher livres par quantité
	
	  @RequestMapping(value="/rechercherLivreQuantite/{min},{max}", method= RequestMethod.GET)
	  public List<Livre> getLivre(@PathVariable int min, int max){ 
		  return lRepository.findByQuantiteBetween(min,max); }
	 


}
