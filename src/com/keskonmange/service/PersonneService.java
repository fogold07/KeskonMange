package com.keskonmange.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.keskonmange.model.Personne;

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
	
	public Personne findPersonne(Long id) {
		return null;
	}

}
