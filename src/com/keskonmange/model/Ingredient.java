package com.keskonmange.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Classe qui définit les attributs de l'ingrédient issu de l'API OpenFoodFact.
 * 
 * @author Christian Ingold, Jean-Philippe Fransisco, Steeve Dombald.
 *
 */
@Entity
@Table(name = "INGREDIENT")
public class Ingredient {
	// TODO : Consolider les données à prendre en compte dans le JSON de l'API

	// *********** ATTRIBUTS ***************
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "LIBELLE", length = 50, nullable = false)
	private String libelle;

	@Column(name = "CALORIE_PORTION", nullable = false)
	private Integer caloriePortion;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_MAJ", nullable = false)
	private Date dateMaj;

	@OneToMany(mappedBy = "ingredientContrainte")
	private Set<Contrainte> contraintes;

	@ManyToMany(mappedBy = "platIngredients")
	private Set<Plat> plats;

	@ManyToMany
	@JoinTable(name = "INGREDIENT_SCORE", joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "score_id", referencedColumnName = "id"))
	private Set<Score> ingredientScores;

	// ************ CONSTRUCTEURS ******************
	public Ingredient() {
		super();
	}

	public Ingredient(String libelle, Integer caloriePortion, Date dateMaj) {
		super();
		this.libelle = libelle;
		this.caloriePortion = caloriePortion;
		this.dateMaj = dateMaj;
	}

	public Integer getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public Integer getCaloriePortion() {
		return caloriePortion;
	}

	public Date getDateMaj() {
		return dateMaj;
	}

	public Set<Contrainte> getContraintes() {
		return contraintes;
	}

	public Set<Plat> getPlats() {
		return plats;
	}

	public Set<Score> getIngredientScores() {
		return ingredientScores;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setCaloriePortion(Integer caloriePortion) {
		this.caloriePortion = caloriePortion;
	}

	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	public void setContraintes(Set<Contrainte> contraintes) {
		this.contraintes = contraintes;
	}

	public void setPlats(Set<Plat> plats) {
		this.plats = plats;
	}

	public void setIngredientScores(Set<Score> ingredientScores) {
		this.ingredientScores = ingredientScores;
	}

}