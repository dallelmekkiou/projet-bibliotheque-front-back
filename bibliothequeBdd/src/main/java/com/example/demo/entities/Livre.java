package com.example.demo.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRE")
public class Livre implements Serializable{

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="titre", length=1000)
    private String titre;
	@Column(name="description", length=1000)
    private String description;
	@Column(name="quantite")
	private int quantite;
    @ManyToOne
	private Bibliotheque bibliotheque;

	

	public Livre(Long id, String titre, String description, int quantite, Bibliotheque bibliotheque) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.quantite=quantite;
		this.bibliotheque = bibliotheque;
	}

	public Livre() {
		super();
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	 public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Bibliotheque getBibliotheque() {
			return bibliotheque;
		}

		public void setBibliotheque(Bibliotheque bibliotheque) {
			this.bibliotheque = bibliotheque;
		}

	

}
