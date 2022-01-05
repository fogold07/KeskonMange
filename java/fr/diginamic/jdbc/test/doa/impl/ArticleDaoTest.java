package fr.diginamic.jdbc.test.doa.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.entites.Article;

public class ArticleDaoTest {
	private ArticleDao adao = new ArticleDaoImpl();

	/**
	 * Test unitaire sur la création d'un article.
	 * Il vérifie que l'article renvoyé par la méthode est non null.
	 * @throws SQLException
	 */
	@Test
	public void test_article_creer() throws SQLException {
		Article a = null;
		
		a = adao.creer(new Article("TST 01", "ARTICLE TEST 01", 100.00, 2));
		
		assertNotNull(a);
	}
	
	/**
	 * Test unitaire sur la recherche d'un article.
	 * il vérifie que l'article renvoyé par la méthode est non null.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void test_article_findOne() throws SQLException {
		String ref = "TST 01";

		Article a = null;

		a = adao.findOne(ref);

		assertNotNull(a);

	}

	/**
	 * Test unitaire sur la mise à jour d'un article.
	 * Il vérifie que le nombre d'article mis à jour est égale à 0 pour un article non existant en base de données
	 */
	@Test
	public void test_article_update() throws SQLException {
		int nbExist = adao.update(new Article("TST 01", "ARTICLE TEST 01", 200.00, 2));
		
		assertThat(nbExist, is(0));

	}

	
	/**
	 * Test unitaire sur l'extraction de tous les articles de la base de données.
	 * Il vérifie que la liste renvoyée n'est pas vide.
	 * @throws SQLException
	 */
	@Test
	public void test_article_extraire() throws SQLException {
		List<Article> result = new ArrayList<>();
		result = adao.extraire();
		
		assertThat(result.isEmpty(), is(false));
	}
	
	/**
	 * Test unitaire sur la suppression d'un article.
	 * Il vérifie que le boolean renvoyé est true, donc que l'article a été supprimé.
	 * @throws SQLException
	 */
	@Test 
	public void test_article_delete() throws SQLException {
		Article article = adao.findOne("TST 01");
		
		Boolean result = adao.delete(article);
	
		assertThat(result, is(true));
	}
}
