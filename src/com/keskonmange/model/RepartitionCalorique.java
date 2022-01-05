package com.keskonmange.model;

import javax.persistence.*;
import com.keskonmange.enumeration.TypeRepas;

/**
 * Classe qui définit la répartition des besoins caloriques pour un groupe.
 * 
 * Exemple: Un groupe a besoin de 10 000 kcal/jour, il choisit la
 * répartition : petit-déjeuner = 20% (2000 kcal), déjeuner = 50% (5000 kcal),
 * diner = 30% (3000 kcal).
 *
 * @author Christian Ingold, Jean-Philippe Fransisco, Steeve Dombald.
 *
 */

@Entity
@Table(name = "REPARTITION_CALORIQUE")
public class RepartitionCalorique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_REPAS", columnDefinition = "enum('PetitDejeuner', 'Dejeuner', 'Diner')", nullable = false)
	private TypeRepas typeRepas;

	@Column(name = "POURCENTAGE", nullable = false)
	private Integer pourcentage;

	@ManyToOne
	@JoinColumn(name = "groupe_id")
	private Groupe repartitionCaloriqueGroupe;

	public RepartitionCalorique() {
		super();
	}

	public RepartitionCalorique(TypeRepas typeRepas, Integer pourcentage) {
		super();
		this.typeRepas = typeRepas;
		this.pourcentage = pourcentage;
	}

	public Integer getId() {
		return id;
	}

	public TypeRepas getTypeRepas() {
		return typeRepas;
	}

	public Integer getPourcentage() {
		return pourcentage;
	}

	public Groupe getRepartitionCaloriqueGroupe() {
		return repartitionCaloriqueGroupe;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTypeRepas(TypeRepas typeRepas) {
		this.typeRepas = typeRepas;
	}

	public void setPourcentage(Integer pourcentage) {
		this.pourcentage = pourcentage;
	}

	public void setRepartitionCaloriqueGroupe(Groupe repartitionCaloriqueGroupe) {
		this.repartitionCaloriqueGroupe = repartitionCaloriqueGroupe;
	}

}
