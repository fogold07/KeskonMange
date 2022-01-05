package com.keskonmange.model;

import java.util.Set;

import javax.persistence.*;

import com.keskonmange.enumeration.TypeScore;

/**
 * Classe qui répertorie les scores (Eco-score, Nova, Nutri-score) pour un
 * ingrédient et un groupe. Elle permettra de filtrer les ingrédients qui
 * correspondent aux critères scrores définis par le groupe.
 * 
 * Exemple : pour un groupe qui ayant filtré son nutri-score sur C,
 * l'application ne proposera pas des ingrédients dont le nutri-score est
 * inférieur à C.
 * 
 * @author Christian Ingold, Jean-Philippe Fransisco, Steeve Dombald.
 *
 */

@Entity
@Table(name = "SCORE")
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "CODE_SCORE", length = 20, nullable = false)
	private String codeScore;

	@Column(name = "LIBELLE", length = 50, nullable = false)
	private String libelle;

	@Column(name = "URL_PHOTO", length = 255, nullable = true)
	private String urlPhoto;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_SCORE", columnDefinition = "enum('Nutri', 'Nova', 'Eco')", nullable = false)
	private TypeScore typeScore;

	@ManyToMany(mappedBy = "groupeScores")
	private Set<Groupe> groupes;

	@ManyToMany(mappedBy = "ingredientScores")
	private Set<Ingredient> ingredients;

	public Score() {
		super();
	}

	public Score(String codeScore, String libelle, String urlPhoto, TypeScore typeScore) {
		super();
		this.codeScore = codeScore;
		this.libelle = libelle;
		this.urlPhoto = urlPhoto;
		this.typeScore = typeScore;
	}

	public Integer getId() {
		return id;
	}

	public String getCodeScore() {
		return codeScore;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public TypeScore getTypeScore() {
		return typeScore;
	}

	public Set<Groupe> getGroupes() {
		return groupes;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCodeScore(String codeScore) {
		this.codeScore = codeScore;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public void setTypeScore(TypeScore typeScore) {
		this.typeScore = typeScore;
	}

	public void setGroupes(Set<Groupe> groupes) {
		this.groupes = groupes;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

}
