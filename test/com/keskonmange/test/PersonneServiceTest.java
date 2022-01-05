package com.keskonmange.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

import com.keskonmange.enumeration.Genre;
import com.keskonmange.model.Activite;
import com.keskonmange.model.Personne;
import com.keskonmange.model.Utilisateur;
import com.keskonmange.service.PersonneService;

public class PersonneServiceTest {

	private PersonneService personneService = new PersonneService();
		
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("kkm_junit");

	
	/**
	 * Test unitaire sur la création d'une personne et d'un utilisateur.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void test_personne_creer() throws SQLException {
		Personne p = null;
		Personne eft1 = null;
		Personne eft2 = null;
		
		Utilisateur u = null;
		
				
		try {
			
			p = personneService.createPersonne(emf, new Personne("DUMOND-GUILLON", "Stephanie", Genre.Feminin, new SimpleDateFormat("dd/MM/yyyy").parse("21/11/1990"), 175, 62, 110, ""));
			assertNotNull(p);
			System.out.println("person added: "+ p.getPrenom() + " " + p.getNom());
			
			eft1 = personneService.createPersonne(emf, new Personne("DUMOND", "Noé", Genre.Masculin, new SimpleDateFormat("dd/MM/yyyy").parse("18/10/2014"), 140, 30, 100, ""));
			assertNotNull(eft1);
			System.out.println("person added: "+ eft1.getPrenom()+ " " + eft1.getNom());
			
			eft2 = personneService.createPersonne(emf, new Personne("DUMOND", "Zoé", Genre.Feminin, new SimpleDateFormat("dd/MM/yyyy").parse("11/05/2017"), 130, 25, 100, ""));
			assertNotNull(eft2);
			System.out.println("person added: "+ eft2.getPrenom()+ " " + eft2.getNom());
			
			Utilisateur user = new Utilisateur("DUMOND", "Vicent", Genre.Masculin, new SimpleDateFormat("dd/MM/yyyy").parse("25/12/1988"), 192, 86, 100, "", "vdumond@gmail.com", "azerty");
			u = personneService.createUtilisateur(emf, user);
			assertNotNull(u);
			System.out.println("user added: "+ u.getEmail() + " (person: "+u.getNom()+" "+u.getPrenom()+")");
			

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	


}
