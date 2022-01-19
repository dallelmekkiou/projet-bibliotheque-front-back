package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Livre;

@CrossOrigin ("http://localhost:4200")
@RestController
public interface LivreRepository extends JpaRepository<Livre, Long> {
	//recherche livres par titre
	@RestResource(path="/byTitre")
	public List<Livre> findByTitreContains(@Param("name")String titre);
	
	//recherche livres par quantité
	@RestResource(path="/byQuantiteBetween")
	public List<Livre> findByQuantiteBetween(@Param("minQte")int minQte,@Param("maxQte")int maxQte); 
}
