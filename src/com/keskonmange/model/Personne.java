package com.keskonmange.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String sexe;
	private LocalDate dateNaissance;
	private Integer taille;
	private Integer poids;
	private Integer objectifCalorique;
	private String urlPhoto;
	
	//TODO : add mapping @OneToMany and @ManyToMany

	public Personne() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public Integer getTaille() {
		return taille;
	}

	public Integer getPoids() {
		return poids;
	}

	public Integer getObjectifCalorique() {
		return objectifCalorique;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setTaille(Integer taille) {
		this.taille = taille;
	}

	public void setPoids(Integer poids) {
		this.poids = poids;
	}

	public void setObjectifCalorique(Integer objectifCalorique) {
		this.objectifCalorique = objectifCalorique;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

}
