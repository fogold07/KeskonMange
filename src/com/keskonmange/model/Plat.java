package com.keskonmange.model;

import java.util.Set;

import javax.persistence.*;

import com.keskonmange.enumeration.TypePlat;

/**
 * Classe qui définit un plat constitué d'un ensemble d'ingrédient.
 * Le plat peut être une entrée, un plat principal, etc.
 *
 * @author Christian Ingold, Jean-Philippe Fransisco, Steeve Dombald.
 *
 */

@Entity
@Table(name="PLAT")
public class Plat {
	
	//*********** ATTRIBUTS ***************
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="LIBELLE", length= 50, nullable = false)
	private String libelle;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_PLAT", columnDefinition = "enum('Entree', 'PlatPrincipal', 'Dessert', 'BoissonChaude', 'Cereales', 'Laitage')")
	private TypePlat typePlat;


	@OneToMany(mappedBy="repasPlat")
	private Set<Repas> repas;		
	
	@ManyToMany
	@JoinTable(name="PLAT_INGREDIENT"
	          ,joinColumns= @JoinColumn(name="plat_id", referencedColumnName="id")
	          ,inverseJoinColumns= @JoinColumn(name="ingredient_id", referencedColumnName="id")
	          )
	private Set<Ingredient> platIngredients;	
	
	
	//************ CONSTRUCTEURS ******************
	public Plat() {

	}

	public Plat(String libelle, TypePlat typePlat) {
		super();
		this.libelle = libelle;
		this.typePlat = typePlat;
	}

	public Integer getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public TypePlat getTypePlat() {
		return typePlat;
	}

	public Set<Repas> getRepas() {
		return repas;
	}

	public Set<Ingredient> getPlatIngredients() {
		return platIngredients;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setTypePlat(TypePlat typePlat) {
		this.typePlat = typePlat;
	}

	public void setRepas(Set<Repas> repas) {
		this.repas = repas;
	}

	public void setPlatIngredients(Set<Ingredient> platIngredients) {
		this.platIngredients = platIngredients;
	}


	

}