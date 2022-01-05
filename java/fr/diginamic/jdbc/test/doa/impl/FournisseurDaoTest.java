package fr.diginamic.jdbc.test.doa.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoTest {

	private FournisseurDao fdao = new FournisseurDaoImpl();
	
	/**
	 * Test unitaire qui vérifie la méthode de création d'un fournisseur.
	 *Il vérifie que l'article renvoyé par la méthode est non null.
	 * @throws SQLException
	 */
	@Test 
	public void test_fournisseur_creer() throws SQLException {
		Fournisseur f = null;
		
		f= fdao.creer(new Fournisseur("TATI"));
		
		assertNotNull(f);
	}
	
	/**
	 * Test unitaire qui vérifie la méthode de recherche d'un fournisseur.
	 * @throws SQLException
	 */
	@Test 
	public void test_fournisseur_findOne() throws SQLException {
		String nom = "FDM SA";
		
		Fournisseur f = null;
		
		f = fdao.findOne(nom);
		
		assertNotNull(f);
		//assertThat(f.getNom(), is(equalTo("TATI")));
		
	}
	
	/**
	 * Test unitaire qui vérifie la mise à jour d'un fournisseur.
	 * Il vérifie que le nombre de fournisseur mis à jour est égale à 0 pour un fournisseur non existant en base de données
	 * @throws SQLException
	 */
	@Test
	public void test_fournisseur_update() throws SQLException {
		Fournisseur f = new Fournisseur("TOTO");

		int nb = fdao.update(f.getNom(), "TOTO SARL");
		
		assertThat(nb, is(0));
	}
	
	@Test
	public void test_fournisseur_extraire() throws SQLException {
		List<Fournisseur> result = new ArrayList<>();
		result = fdao.extraire();
		
		assertThat(result.isEmpty(), is(false));
	}
	
	/**
	 * Test unitaire qui vérifie la méthode de suppression d'un fournisseur.
	 * Il vérifie que le boolean renvoyé est true, donc que le fournisseur a été supprimé. 
	 * @throws SQLException
	 */
	@Test
	public void test_fournisseur_delete() throws SQLException {
		Fournisseur f = fdao.findOne("TATI");
		
		Boolean result = fdao.delete(f);
		
		assertThat(result, is(true));
	}
	
}
