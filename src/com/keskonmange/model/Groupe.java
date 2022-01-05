package com.keskonmange.model;

import java.util.Set;

import javax.persistence.*;

/**
 * Classe qui définit un groupe composé de plusieurs personnes pouvant être des
 * administrateurs ou non.
 * Exemple : dans une famille comoposée de 2 adultes et
 * 2 enfants, le groupe pourra être administré par un seul des deux parents ou par les
 * deux. Les enfants quand à eux seront iditifiés comme simple "personnes" dans le
 * groupe.
 * 
 * @author Christian Ingold, Jean-Philippe Fransisco, Steeve Dombald.
 *
 */

@Entity
@Table(name = "GROUPE")
public class Groupe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NOM", length = 50, nullable = true)
	private String nom;

	@Column(name = "URL_PHOTO", length = 200, nullable = true)
	private String urlPhoto;

	@ManyToMany
	@JoinTable(name = "ADMINISTRATEUR", joinColumns = @JoinColumn(name = "groupe_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "utilisateur_id", referencedColumnName = "id"))
	private Set<Utilisateur> administrateurs;

	@ManyToMany
	@JoinTable(name = "GROUPE_PERSONNE", joinColumns = @JoinColumn(name = "groupe_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "personne_id", referencedColumnName = "id"))
	private Set<Personne> groupePersonnes;

	@OneToMany(mappedBy = "absenceGroupe")
	private Set<Absence> absences;

	@OneToMany(mappedBy = "repartitionCaloriqueGroupe")
	private Set<RepartitionCalorique> repartitionCaloriques;

	@ManyToMany
	@JoinTable(name = "GROUPE_SCORE", joinColumns = @JoinColumn(name = "groupe_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "score_id", referencedColumnName = "id"))
	private Set<Score> groupeScores;

	@OneToMany(mappedBy = "repasGroupe")
	private Set<Repas> repas;

	public Groupe() {
	}

	public Groupe(String nom, String urlPhoto) {
		super();
		this.nom = nom;
		this.urlPhoto = urlPhoto;
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public Set<Utilisateur> getAdministrateurs() {
		return administrateurs;
	}

	public Set<Personne> getGroupePersonnes() {
		return groupePersonnes;
	}

	public Set<Absence> getAbsences() {
		return absences;
	}

	public Set<RepartitionCalorique> getRepartitionCaloriques() {
		return repartitionCaloriques;
	}

	public Set<Score> getGroupeScores() {
		return groupeScores;
	}

	public Set<Repas> getRepas() {
		return repas;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public void setAdministrateurs(Set<Utilisateur> administrateurs) {
		this.administrateurs = administrateurs;
	}

	public void setGroupePersonnes(Set<Personne> groupePersonnes) {
		this.groupePersonnes = groupePersonnes;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}

	public void setRepartitionCaloriques(Set<RepartitionCalorique> repartitionCaloriques) {
		this.repartitionCaloriques = repartitionCaloriques;
	}

	public void setGroupeScores(Set<Score> groupeScores) {
		this.groupeScores = groupeScores;
	}

	public void setRepas(Set<Repas> repas) {
		this.repas = repas;
	}


}
