package com.keskonmange.model;

import javax.persistence.*;

import com.keskonmange.enumeration.TypeScore;

@Entity
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codeScore;
	private String libelle;
	private String urlPhoto;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_SCORE", columnDefinition = "enum(	'NutriScore', 'NovaScore', 'EcoScore')")
	private TypeScore typeScore;

	// TODO : add mapping @OneToMany and @ManyToMany

	public Score() {
		super();
	}

	public Long getId() {
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

	public void setId(Long id) {
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

}
