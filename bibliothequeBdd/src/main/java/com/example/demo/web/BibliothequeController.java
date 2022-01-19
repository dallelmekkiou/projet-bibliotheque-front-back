package com.example.demo.web;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Bibliotheque;
import com.example.demo.entities.Livre;

import net.bytebuddy.utility.RandomString;

import com.example.demo.dao.BibliothequeRepository;

@RestController
public class BibliothequeController {
	
	@Autowired
	private BibliothequeRepository bRepository;
	
	//Get une bibliotheque
    @RequestMapping(value="/getBibliotheque/{id}", method= RequestMethod.GET)  
	public Bibliotheque getBibliotheque(@PathVariable Long id){
	        return bRepository.findById(id).orElse(null);  
	    }
    
	//Get les bibliotheques
    @RequestMapping(value="/getBibliotheques", method= RequestMethod.GET)  
	public List<Bibliotheque> getBibliotheques(){
	        return bRepository.findAll();  
	    }
    
    //Add bibliotheque
    @RequestMapping(value="/addBibliotheque", method=RequestMethod.POST)
	public Bibliotheque addBibliotheque(@RequestBody Bibliotheque b) {
    	return bRepository.save(b);	
	}

	//Edit
	@RequestMapping(value="/editBibliotheque/{id}", method=RequestMethod.PUT)
	public Bibliotheque editBibliotheque(@PathVariable Long id, @RequestBody Bibliotheque b) {
		if (bRepository.findById(id).isPresent()) {
		    b.setId(id);
		    return bRepository.save(b);
	    }else {
		return b;
	    }
	}
	

	//Edit un seul attribut dans bibliotheque
	@RequestMapping(value="/patchBibliotheque/{id}",method=RequestMethod.PATCH)
	public Bibliotheque patchBibliotheque(@PathVariable Long id, @RequestBody Map<String, Object> changes) {
        Bibliotheque b = bRepository.findById(id).get();
		changes.forEach(
                (change, value) -> {
                    switch (change){
                        case "nom": b.setNom((String) value); break;
                        case "description": b.setDescription((String) value); break;
                        case "image": b.setImage((String) value); break;
                        case "adresse": b.setAdresse((String) value); break;
                        case "tel": b.setTel((String) value); break;

                    }
                });
		
		return bRepository.save(b);
	}
	
	//Delete bibliotheque avec id
	@RequestMapping(value="/deleteBibliotheque/{id}", method=RequestMethod.DELETE)
	public boolean deleteBibliotheque(@PathVariable Long id) {
		bRepository.deleteById(id);
		return true;
	}
	
	//add bibliotheque aléatoire
	@PostMapping(value="/addBibliothequeAleatoire/{nbr}")
	public boolean addBibliothequeAleatoire(@PathVariable int nbr){
	Random rand = new Random();
	for (int i=0; i<=nbr;i++) {
	   bRepository.save(new Bibliotheque(null,RandomString.make(100),RandomString.make(100),RandomString.make(100),RandomString.make(100),RandomString.make(100),rand.nextInt(100),null));	
	}
	 return true;
	}
	
	//ajouter les nbr abonnées a bibliotheques
	@PostMapping(value="/addAdherents")
	public boolean addAdherents(){
	Random random = new Random(); 
	  bRepository.findAll().forEach(b->{ 
		  b.setNbrAdherent(random.nextInt(100));      
    });
	return true; 
	}  
	
	//rechercher bibliotheques par mot clé
	@GetMapping("/rechercherBibliotheque/{motCle}")  
	public List<Bibliotheque> rechercherBibliotheque(@PathVariable String motCle){
	        return bRepository.findByNomContains(motCle);  
	    }
	
	//rechercher bibliotheque par nbr adherents between
	@GetMapping("/rechercherBibliothequeNbrAdherent/{min},{max}")
	public List<Bibliotheque> rechercherBibliothequeNbrAdherent(@PathVariable int min,@PathVariable int max){
		return bRepository.findByNbrAdherentBetween(min,max);		
	}

}
