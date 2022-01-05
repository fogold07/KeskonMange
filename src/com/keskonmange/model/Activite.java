package com.keskonmange.model;

import javax.persistence.*;

/**
 * Classe qui repertorie l'ensemble des paires activité-coefficient nécessaires
 * au calcul du besoin calorique hebdomadaire. 
 * Exemple : une personne avec un profil sédentaire aura un coefficient de 1.2.
 * 
 * @author Christian Ingold, Jean-Philippe Fransisco, Steeve Dombald.
 *
 */
@Entity
@Table(name = "ACTIVITE")
public class Activite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "LIBELLE", length = 50, nullable = false)
	private String libelle;

	@Column(name = "COEFFICIENT", nullable = true)
	private Double coefficient;

	public Activite() {
		super();
	}

	public Activite(String libelle, Double coefficient) {
		super();
		this.libelle = libelle;
		this.coefficient = coefficient;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the coefficient
	 */
	public Double getCoefficient() {
		return coefficient;
	}

	/**
	 * @param coefficient the coefficient to set
	 */
	public void setCoefficient(Double coefficient) {
		this.coefficient = coefficient;
	}

}