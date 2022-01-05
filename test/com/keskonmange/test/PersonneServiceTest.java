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

public class PersonneServiceTest {

	private PersonneService personneService = new PersonneService();
	
	private GroupeService groupeService = new GroupeService();
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("kkm_junit");

	@Test
	public void test_personne_creer() throws SQLException {
		Personne p = null;
		Personne eft1 = null;
		Personne eft2 = null;
		
		Utilisateur u = null;
		
		Groupe gpe = null; 
		
		try {
			p = personneService.createPersonne(emf, new Personne("DUMOND-GUILLI", "Stephanie", Genre.Feminin, new SimpleDateFormat("dd/MM/yyyy").parse("21/11/1990"), 175, 62, 110, ""));
			assertNotNull(p);
			System.out.println("person added: "+ p.getPrenom());
			
			eft1 = personneService.createPersonne(emf, new Personne("DUMOND", "Noé", Genre.Masculin, new SimpleDateFormat("dd/MM/yyyy").parse("18/10/2014"), 140, 30, 100, ""));
			assertNotNull(eft1);
			System.out.println("person added: "+ p.getPrenom());
			
			eft2 = personneService.createPersonne(emf, new Personne("DUMOND", "Zoé", Genre.Feminin, new SimpleDateFormat("dd/MM/yyyy").parse("11/05/2017"), 130, 25, 100, ""));
			assertNotNull(eft2);
			System.out.println("person added: "+ p.getPrenom());
			
			Utilisateur user = new Utilisateur("DUMOND", "Vivient", Genre.Masculin, new SimpleDateFormat("dd/MM/yyyy").parse("25/12/1988"), 192, 86, 100, "", "vdumond@gmail.com", "azerty");
			u = personneService.createUtilisateur(emf, user);
			assertNotNull(u);
			System.out.println("user added: "+ u.getEmail());
			
			Set<Utilisateur> users = new HashSet<>();
			users.add(u);
			
			Set<Personne> personnes = new HashSet<>();
			personnes.add(p);
			personnes.add(u);
			personnes.add(eft1);
			personnes.add(eft2);
			
			gpe = groupeService.createGroupe(emf, new Groupe("DG-78", ""), users, personnes);
			assertNotNull(gpe);
			System.out.println("group added: "+ gpe.getNom());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	


}
