package com.keskonmange;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.keskonmange.connexion.ConnexionBddJpa;


public class App {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = ConnexionBddJpa.getConnexionJpa();
			em = emf.createEntityManager();
			em.close();
		}     	catch(Exception e) {e.printStackTrace();}
    	finally {
			if (emf != null)
				emf.close();
		}

	}

}
