package fr.diginamic.jdbc.test.doa.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.diginamic.jdbc.dao.BonDao;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.entites.Bon;

public class BonDaoTest {
	private BonDao bdao = new BonDaoImpl();

	/**
	 * Test unitaire sur la création d'un bon.
	 * Il vérifie que le bon renvoyé par la méthode est non null.
	 * @throws SQLException
	 */
	@Test
	public void test_bon_creer() throws SQLException {
		Bon b = null;
		
		b = bdao.creer(new Bon(7, 5, 1));
		
		assertNotNull(b);
	}
	
	/**
	 * Test unitaire sur la recherche d'un bon.
	 * il vérifie que le bon renvoyé par la méthode est non null.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void test_bon_findOne() throws SQLException {

		Bon b = null;

		b = bdao.findOne(6);

		assertNotNull(b);

	}

	/**
	 * Test unitaire sur la mise à jour d'un bon.
	 * Il vérifie que le nombre de bons mis à jour est égale à 0 pour un bon non existant en base de données
	 */
	@Test
	public void test_bon_update() throws SQLException {
		int nbExist = bdao.update(new Bon(7, 10, 1));
		
		assertThat(nbExist, is(0));

	}

	
	/**
	 * Test unitaire sur l'extraction de tous les bons de la base de données.
	 * Il vérifie que la liste renvoyée n'est pas vide.
	 * @throws SQLException
	 */
	@Test
	public void test_bon_extraire() throws SQLException {
		List<Bon> result = new ArrayList<>();
		result = bdao.extraire();
		
		assertThat(result.isEmpty(), is(false));
	}
	
	/**
	 * Test unitaire sur la suppression d'un bon.
	 * Il vérifie que le boolean renvoyé est true, donc que le bon a été supprimé.
	 * @throws SQLException
	 */
	@Test 
	public void test_bon_delete() throws SQLException {
		Bon bon = bdao.findOne(7);
		
		Boolean result = bdao.delete(bon);
	
		assertThat(result, is(true));
	}
}
