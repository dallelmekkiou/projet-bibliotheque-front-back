package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "BIBLIOTHEQUE")
public class Bibliotheque implements Serializable{
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="nom", length=1000)
	private String nom;
	@Column(name="description", length=2000)
	private String description;
	@Column(name="image", length=2000)
	private String image;
	@Column(name="adresse", length=1000)
	private String adresse;
	@Column(name="tel")
	private String tel;
	@Column(name="nbrAdherent")
	private int nbrAdherent;
	@OneToMany(mappedBy="bibliotheque")
	private Collection<Livre>livres;

	public Bibliotheque() {
	}

	public Bibliotheque(Long id, String nom, String description, String image, String adresse, String tel,
			int nbrAdherent, Collection<Livre> livres) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.image = image;
		this.adresse = adresse;
		this.tel = tel;
		this.nbrAdherent = nbrAdherent;
		this.livres = livres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public int getNbrAdherent() {
		return nbrAdherent;
	}

	public void setNbrAdherent(int nbrAdherent) {
		this.nbrAdherent = nbrAdherent;
	}

	public Collection<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Collection<Livre> livres) {
		this.livres = livres;
	}

	@Override
	public String toString() {
		return "Bibliotheque [id=" + id + ", nom=" + nom + ", description=" + description + ", image=" + image
				+ ", tel=" + tel + ", adresse=" + adresse + "]";
	}
	
	
	

}

