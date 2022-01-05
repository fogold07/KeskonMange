package com.keskonmange.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.keskonmange.model.Personne;
import com.keskonmange.model.Utilisateur;

public class PersonneService {


   private EntityManager em = null;


	public Personne createPersonne(EntityManagerFactory emf, Personne personne) {

		try {
			em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(personne);
			em.getTransaction().commit();

			return personne;

		} finally {
			if (em != null)
				em.close();
		}
		
	}
	
	public Personne updatePersonne(Personne personne) {
		return personne;
	}
	
	public Personne findPersonne(Integer id) {
		return null;
	}

	
	public Boolean deletePersonne(Personne personne) {
		return false;
	}
	
	public Utilisateur createUtilisateur(EntityManagerFactory emf, Utilisateur user) {
		try {
			em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();

			return user;

		} finally {
			if (em != null)
				em.close();
		}

	}
}
