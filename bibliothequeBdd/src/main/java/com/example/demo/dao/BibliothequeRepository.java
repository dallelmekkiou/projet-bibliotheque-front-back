package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Bibliotheque;
import com.example.demo.entities.Livre;

import java.util.List;

@CrossOrigin ("http://localhost:4200")
@RestController
public interface BibliothequeRepository extends JpaRepository<Bibliotheque, Long> {
	
	@RestResource(path="/byName")
	public List<Bibliotheque>findByNomContains(@Param("name")String nom);
	
	//recherche livres par nombre adherents
	
	@RestResource(path="/byNbrAdherentBetween")
	public List<Bibliotheque>findByNbrAdherentBetween(@Param("min")int min,@Param("max")int max); 

}
