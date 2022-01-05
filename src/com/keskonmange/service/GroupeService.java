package com.keskonmange.service;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.keskonmange.model.Groupe;
import com.keskonmange.model.Personne;
import com.keskonmange.model.Utilisateur;

public class GroupeService {


   private EntityManager em = null;


	public Groupe createGroupe(EntityManagerFactory emf, Groupe gpe, Set<Utilisateur> users, Set<Personne> personnes) {

		try {
			em = emf.createEntityManager();

			em.getTransaction().begin();
			//Set<Utilisateur> users = new HashSet<Utilisateur>();
			//users.add(user);
			gpe.setAdministrateurs(users);
			
			//Set<Personne> personnes = new HashSet<Personne>();
			//personnes.add(p);
			gpe.setGroupePersonnes(personnes);
			
			em.persist(gpe);
			em.getTransaction().commit();

			return gpe;

		} finally {
			if (em != null)
				em.close();
		}
		
	}
	

}
