package com.keskonmange.test;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.keskonmange.enumeration.Genre;
import com.keskonmange.model.Personne;
import com.keskonmange.service.PersonneService;

public class PersonneServiceTest {

	private PersonneService service = new PersonneService();
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("kkm_junit");

	@Test
	public void test_personne_creer() throws SQLException {
		Personne p;
		try {
			p = service.createPersonne(emf, new Personne("DOMBALD", "Steeve", Genre.Masculin, new SimpleDateFormat("dd/MM/yyyy").parse("21/11/1990"), 181, 92, 100, ""));
			assertNotNull(p);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
