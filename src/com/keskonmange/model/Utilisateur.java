package com.keskonmange.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.keskonmange.enumeration.Genre;

/**
 * Classe qui définie l'utilisateur ainsi que si oui ou non il est administrateur d'un groupe.
 * 
 * @author Christian Ingold, Jean-Philippe Fransisco, Steeve Dombald.
 *
 */

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur extends Personne {

	@Column(name = "EMAIL", length = 200, nullable = false)
	private String email;
	
	@Column(name = "PWD", length = 200, nullable = false)
	private String pwd;
	
	@ManyToMany(mappedBy="administrateurs")
	private Set<Groupe> groupes;
	
	
	public Utilisateur() {
	}



	public Utilisateur(String nom, String prenom, Genre genre, Date dateNaissance, Integer taille, Integer poids, Integer objectifCalorique, String urlPhoto, String email, String pwd) {
		super(nom, prenom, genre, dateNaissance, taille, poids, objectifCalorique, urlPhoto);
		this.email = email;
		this.pwd = pwd;
	}


	public Utilisateur(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}



	public String getEmail() {
		return email;
	}

	public String getPwd() {
		return pwd;
	}

	public Set<Groupe> getGroupes() {
		return groupes;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setGroupes(Set<Groupe> groupes) {
		this.groupes = groupes;
	}


}
