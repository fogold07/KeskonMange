package com.keskonmange.model;

import javax.persistence.Column;
import javax.persistence.*;

import com.keskonmange.enumeration.TypeRepas;

/**
 * Classe qui repertorie les absences d'une personne et d'un groupe à un repas
 * donné.
 *
 * @author Christian Ingold, Jean-Philippe Fransisco, Steeve Dombald.
 *
 */
@Entity
@Table(name = "ABSENCE")
public class Absence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_REPAS", columnDefinition = "enum('PetitDejeuner', 'Dejeuner', 'Diner')")
	private TypeRepas typeRepas;

	@ManyToOne
	@JoinColumn(name = "personne_id")
	private Personne absencePersonne;

	@ManyToOne
	@JoinColumn(name = "groupe_id")
	private Groupe absenceGroupe;

	public Absence() {
	}

	public Absence(TypeRepas typeRepas) {
		super();
		this.typeRepas = typeRepas;
	}

	public Personne getAbsencePersonne() {
		return absencePersonne;
	}

	public Groupe getAbsenceGroupe() {
		return absenceGroupe;
	}

	public void setAbsencePersonne(Personne absencePersonne) {
		this.absencePersonne = absencePersonne;
	}

	public void setAbsenceGroupe(Groupe absenceGroupe) {
		this.absenceGroupe = absenceGroupe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypeRepas getTypeRepas() {
		return typeRepas;
	}

	public void setTypeRepas(TypeRepas typeRepas) {
		this.typeRepas = typeRepas;
	}
	
	

}
