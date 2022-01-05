package com.keskonmange.connexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe qui cree une persistence de  l'EntityManagerFactory.
 * 
 * @author Christian Ingold
 *
 */
public class ConnexionBddJpa {

	
	public static EntityManagerFactory getConnexionJpa() {
		return getConnexionJpa("kkm_junit");
	}
	
	public static EntityManagerFactory getConnexionJpa(String unitePersistense) {
		return Persistence.createEntityManagerFactory(unitePersistense);
		
	}
}
