package com.keskonmange.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.keskonmange.enumeration.Genre;

/**
 * Classe qui définit les attributs d'une personne enregistrée dans l'application.
 * 
 * @author Christian Ingold, Jean-Philippe Fransisco, Steeve Dombald.
 *
 */

@Entity
@Table(name = "PERSONNE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOM", length = 50, nullable = true)
	private String nom;
	
	@Column(name = "PRENOM", length = 50, nullable = true)
	private String prenom;
	
	@Enumerated(EnumType.STRING)
    @Column(name="GENRE",columnDefinition = "enum('Masculin', 'Feminin')")
	private Genre genre ;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_NAISSANCE", nullable=true)
	private Date dateNaissance;
	
	@Column(name = "TAILLE", nullable = true)
	private Integer taille;
	
	@Column(name = "POIDS", nullable = true)
	private Integer poids;
	
	@Column(name = "OBJECTIF_CALORIQUE", nullable = true)
	private Integer objectifCalorique;
	
	@Column(name = "URL_PHOTO", length = 200, nullable = true)
	private String urlPhoto;

	@OneToOne
	private Activite activite;
	
	@OneToMany(mappedBy="personneContrainte")
	private Set<Contrainte> contraintes;
	
	@ManyToMany(mappedBy="groupePersonnes")
	private Set<Groupe> groupes;	
	
	@OneToMany(mappedBy="absencePersonne")
	private Set<Absence> absences;	
	
	
	public Personne() {
	}

	public Personne(String nom, String prenom, Genre genre, Date dateNaissance, Integer taille,
			Integer poids, Integer objectifCalorique, String urlPhoto) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.dateNaissance = dateNaissance;
		this.taille = taille;
		this.poids = poids;
		this.objectifCalorique = objectifCalorique;
		this.urlPhoto = urlPhoto;
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Genre getGenre() {
		return genre;
	}

	public Date getDateNaissance() {
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

	public Activite getActivite() {
		return activite;
	}

	public Set<Contrainte> getContraintes() {
		return contraintes;
	}

	public Set<Groupe> getGroupes() {
		return groupes;
	}

	public Set<Absence> getAbsences() {
		return absences;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void setDateNaissance(Date dateNaissance) {
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

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	public void setContraintes(Set<Contrainte> contraintes) {
		this.contraintes = contraintes;
	}

	public void setGroupes(Set<Groupe> groupes) {
		this.groupes = groupes;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}

	

}
