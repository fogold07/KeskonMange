package com.keskonmange.test;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.keskonmange.enumeration.Genre;
import com.keskonmange.model.Groupe;
import com.keskonmange.model.Personne;
import com.keskonmange.model.Utilisateur;
import com.keskonmange.service.GroupeService;
import com.keskonmange.service.PersonneService;

public class GroupeServiceTest {

	private PersonneService personneService = new PersonneService();
	
	private GroupeService groupeService = new GroupeService();
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("kkm_junit");

	
	/**
	 * Test unitaire sur la création d'un groupe.
	 * 
	 * @throws SQLException
	 * 
	 */
	@Test
	public void test_groupe_creer() throws SQLException {
		
		Groupe gpe = null; 
		
		try {
			Personne p =  new Personne("DUMOND-GUILLON", "Stephanie", Genre.Feminin, new SimpleDateFormat("dd/MM/yyyy").parse("21/11/1990"), 175, 62, 110, "");
			Personne eft1 = new Personne("DUMOND", "Noé", Genre.Masculin, new SimpleDateFormat("dd/MM/yyyy").parse("18/10/2014"), 140, 30, 100, "");
			Personne eft2 = new Personne("DUMOND", "Zoé", Genre.Feminin, new SimpleDateFormat("dd/MM/yyyy").parse("11/05/2017"), 130, 25, 100, "");
						
			Utilisateur user = new Utilisateur("DUMOND", "Vincent", Genre.Masculin, new SimpleDateFormat("dd/MM/yyyy").parse("25/12/1988"), 192, 86, 100, "", "vdumond@gmail.com", "azerty");
			
			personneService.createPersonne(emf, p);
			personneService.createPersonne(emf, eft1);
			personneService.createPersonne(emf, eft2);
			personneService.createUtilisateur(emf, user);
			
			Set<Utilisateur> users = new HashSet<>();
			users.add(user);
			
			Set<Personne> personnes = new HashSet<>();
			personnes.add(p);
			personnes.add(user);
			personnes.add(eft1);
			personnes.add(eft2);
			
			gpe = groupeService.createGroupe(emf, new Groupe("DG-78", ""), users, personnes);
			assertNotNull(gpe);
			System.out.println("group "+ gpe.getNom() + " added, members are: ");
			gpe.getGroupePersonnes().stream().forEach(gp -> System.out.println("- "+gp.getNom()+" " + gp.getPrenom()));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


}
