package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.User;

@CrossOrigin("http://localhost:4200")
@RestController
public interface UserRepository extends JpaRepository<User, Long>{
	
	@RestResource(path="/byName")
	public List<User>findByUsernameContains(@Param("name")String nomProduit);

}
