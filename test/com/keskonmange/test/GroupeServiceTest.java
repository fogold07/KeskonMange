package com.keskonmange.test;

import static org.junit.Assert.assertNotNull;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	 * @throws NoSuchAlgorithmException
	 * 
	 */
	@Test
	public void test_groupe_creer() throws SQLException, NoSuchAlgorithmException {

		Groupe gpe = null;

		try {
			Personne p = new Personne("DUMOND-GUILLON", "Stephanie", Genre.Feminin,
					new SimpleDateFormat("dd/MM/yyyy").parse("21/11/1990"), 175, 62, 110, "");
			Personne eft1 = new Personne("DUMOND", "Noé", Genre.Masculin,
					new SimpleDateFormat("dd/MM/yyyy").parse("18/10/2014"), 140, 30, 100, "");
			Personne eft2 = new Personne("DUMOND", "Zoé", Genre.Feminin,
					new SimpleDateFormat("dd/MM/yyyy").parse("11/05/2017"), 130, 25, 100, "");

			// Hachade du password
			String str = "azertyuiop";
			MessageDigest msg = MessageDigest.getInstance("SHA-256");
			byte[] hash = msg.digest(str.getBytes(StandardCharsets.UTF_8));

			StringBuilder s = new StringBuilder();
			for (byte b : hash) {
				s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			}
			String generatedPwd = s.toString();

			Utilisateur user = new Utilisateur("DUMOND", "Vincent", Genre.Masculin,
					new SimpleDateFormat("dd/MM/yyyy").parse("25/12/1988"), 192, 86, 100, "", "vdumond@gmail.com",
					generatedPwd);

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

			gpe = groupeService.createGroupe(emf, new Groupe("Famille DUMOND 75", ""), users, personnes);
			assertNotNull(gpe);
			System.out.println("Groupe nommé - " + gpe.getNom() + " - ajouté avec succès!");
			System.out.println("------------------------------- ");
			System.out.println("Liste des personnes du groupe : ");
			gpe.getGroupePersonnes().stream()
					.forEach(gp -> System.out.println("- " + gp.getNom() + " " + gp.getPrenom()));
			System.out.println("------------------------------- ");
			System.out.print("Administrateur : ");gpe.getAdministrateurs().stream().forEach(adm ->  System.out.println(adm.getPrenom()));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
