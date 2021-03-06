package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //constructeur sans arguments
@AllArgsConstructor //constructeur avec arguments
    @Entity
	@Table(name = "USER")
	public class User implements Serializable{
    	
        
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private Long id;
	    @Column(name="username")
	    private String username;
	    @Column(name="password")
	    private String password;
	    
	   
		/*
		 * public User() { super(); } public User(Long id, String username, String
		 * password) { super(); this.id = id; this.username = username; this.password =
		 * password;
		 * 
		 * } public Long getId() { return id; } public void setId(Long id) { this.id =
		 * id; } public String getUsername() { return username; } public void
		 * setUsername(String username) { this.username = username; }
		 * 
		 * public String getPassword() { return password; } public void
		 * setPassword(String password) { this.password = password; }
		 * 
		 * @Override public String toString() { return "User [id=" + id + ", username="
		 * + username + ", password=" + password + "]"; }
		 */
	   
		
	    
	   
	    
	    
	    
}


