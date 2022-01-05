package fr.diginamic.jdbc.test.doa.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.diginamic.jdbc.dao.CompoDao;
import fr.diginamic.jdbc.dao.impl.CompoDaoImpl;
import fr.diginamic.jdbc.entites.Compo;

public class CompoDaoTest {
	private CompoDao cdao = new CompoDaoImpl();

	/**
	 * Test unitaire sur la création d'une compo.
	 * Il vérifie que la compo renvoyée par la méthode est non null.
	 * @throws SQLException
	 */
	@Test
	public void test_compo_creer() throws SQLException {
		int result = cdao.creer(new Compo(8, 6, 12));
		
		assertThat(result, is(1));
	}
	

	/**
	 * Test unitaire sur la mise à jour d'une compo.
	 * Il vérifie que le nombre de compos mis à jour est égale à 0 pour une compo non existant en base de données
	 */
	@Test
	public void test_compo_update() throws SQLException {
		int nbExist = cdao.update(new Compo(0, 8, 6, 7));
		
		assertThat(nbExist, is(0));

	}

	
	/**
	 * Test unitaire sur l'extraction de toutes les compos de la base de données.
	 * Il vérifie que la liste renvoyée n'est pas vide.
	 * @throws SQLException
	 */
	@Test
	public void test_compo_extraire() throws SQLException {
		List<Compo> result = new ArrayList<>();
		result = cdao.extraire();
		
		assertThat(result.isEmpty(), is(false));
	}
	
	/**
	 * Test unitaire sur la suppression d'une compo.
	 * Il vérifie que le boolean renvoyé est false car compo non existante.
	 * @throws SQLException
	 */
	@Test 
	public void test_compo_delete() throws SQLException {
		
		Boolean result = cdao.delete(0);
	
		assertThat(result, is(false));
	}
}
