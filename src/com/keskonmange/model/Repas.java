package com.keskonmange.model;

import java.util.Date;

import javax.persistence.*;

import com.keskonmange.enumeration.TypeRepas;

/**
 * Classe qui définit ce qu'est un repas pour un plat et un groupe.
 * 
 * Exemple : repas 1 = déjeuner, concerne le plat X du groupe A.
 *
 * @author Christian Ingold, Jean-Philippe Fransisco, Steeve Dombald.
 *
 */

@Entity
@Table(name="REPAS")
public class Repas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_REPAS", nullable=false)
	private Date dateRepas;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_REPAS", columnDefinition = "enum('PetitDejeuner', 'Dejeuner', 'Diner')", nullable = false)
    private TypeRepas typeRepas;

	@ManyToOne
	@JoinColumn(name="groupe_id")
	private Groupe repasGroupe;		
	
	@ManyToOne
	@JoinColumn(name="plat_id")
	private Plat repasPlat;		

	
	public Repas() {
		super();
	}

	public Repas(Date dateRepas, TypeRepas typeRepas) {
		super();
		this.dateRepas = dateRepas;
		this.typeRepas = typeRepas;
	}

	public Integer getId() {
		return id;
	}

	public Date getDateRepas() {
		return dateRepas;
	}

	public TypeRepas getTypeRepas() {
		return typeRepas;
	}

	public Groupe getRepasGroupe() {
		return repasGroupe;
	}

	public Plat getRepasPlat() {
		return repasPlat;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDateRepas(Date dateRepas) {
		this.dateRepas = dateRepas;
	}

	public void setTypeRepas(TypeRepas typeRepas) {
		this.typeRepas = typeRepas;
	}

	public void setRepasGroupe(Groupe repasGroupe) {
		this.repasGroupe = repasGroupe;
	}

	public void setRepasPlat(Plat repasPlat) {
		this.repasPlat = repasPlat;
	}

	
}
