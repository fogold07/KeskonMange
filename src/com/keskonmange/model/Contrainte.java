package com.keskonmange.model;

import javax.persistence.*;

import com.keskonmange.enumeration.TypeContrainte;

/**
 * Classe qui repertorie l'ensemble des contraintes alimentaires pour des
 * ingr�dients et une personne donn�e. Dans le but d'exclure les ingr�dients qui
 * prennent en compte ces contraintes. Exemple : une personne X est allergique �
 * un ingr�dient A et n'aime pas l'ingr�dient B.
 * 
 * @author Christian Ingold, Jean-Philippe Fransisco, Steeve Dombald.
 *
 */

@Entity
@Table(name = "CONTRAINTE")
public class Contrainte {

	// *********** ATTRIBUTS ***************
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_CONTRAINTE", columnDefinition = "enum('Allergie', 'Gout')")
	private TypeContrainte typeContrainte;

	@ManyToOne
	@JoinColumn(name = "personne_id")
	private Personne personneContrainte;

	@ManyToOne
	@JoinColumn(name = "ingredient_id")
	private Ingredient ingredientContrainte;

	// ************ CONSTRUCTEURS ******************
	public Contrainte() {
		super();
	}

	public Contrainte(TypeContrainte typeContrainte) {
		super();
		this.typeContrainte = typeContrainte;
	}

	
	public Integer getId() {
		return id;
	}

	public TypeContrainte getTypeContrainte() {
		return typeContrainte;
	}

	public Personne getPersonneContrainte() {
		return personneContrainte;
	}

	public Ingredient getIngredientContrainte() {
		return ingredientContrainte;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTypeContrainte(TypeContrainte typeContrainte) {
		this.typeContrainte = typeContrainte;
	}

	public void setPersonneContrainte(Personne personneContrainte) {
		this.personneContrainte = personneContrainte;
	}

	public void setIngredientContrainte(Ingredient ingredientContrainte) {
		this.ingredientContrainte = ingredientContrainte;
	}

}
