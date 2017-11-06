package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes={ ServicesConfig.class, JeuxDeDonneesConfig.class})
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	
	@Autowired
	private CotisationService cotisationService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		Cotisation nouveauCotisation = new Cotisation(null, null, null, null);
		String codePush = "cc";
		String libellePush = "ARCO";
		BigDecimal tauxSalarialPush = new BigDecimal(80);
		BigDecimal tauxPatronalPush = new BigDecimal(160);
		
		nouveauCotisation.setCode(codePush);
		nouveauCotisation.setLibelle(libellePush);
		nouveauCotisation.setTauxSalarial(tauxSalarialPush);
		nouveauCotisation.setTauxPatronal(tauxPatronalPush);
		cotisationService.sauvegarder(nouveauCotisation);
		
		assertThat(nouveauCotisation.getCode(), equalTo("cc"));
		assertThat(nouveauCotisation.getLibelle(), equalTo("ARCO"));
		assertThat(nouveauCotisation.getTauxSalarial(), equalTo(new BigDecimal(80)));
		assertThat(nouveauCotisation.getTauxPatronal(), equalTo(new BigDecimal(160)));
		
		
		
		String codeEdit = "AAAAAAAAA";
		String libelleEdit = "OOOOOOOOOOO";
		BigDecimal tauxSalarialEdit = new BigDecimal(800);
		BigDecimal tauxPatronalEdit = new BigDecimal(16000);
		Integer idEdit = new Integer(1);
		
		
		
		nouveauCotisation.setCode(codeEdit);
		nouveauCotisation.setLibelle(libelleEdit);
		nouveauCotisation.setTauxSalarial(tauxSalarialEdit);
		nouveauCotisation.setTauxPatronal(tauxPatronalEdit);
		cotisationService.mettreAJour(nouveauCotisation);
		
		assertThat(nouveauCotisation.getCode(), equalTo("AAAAAAAAA"));
		assertThat(nouveauCotisation.getLibelle(), equalTo("OOOOOOOOOOO"));
		assertThat(nouveauCotisation.getTauxSalarial(), equalTo(new BigDecimal(800)));
		assertThat(nouveauCotisation.getTauxPatronal(), equalTo(new BigDecimal(16000)));
	}

}
