package dev.paie.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.service.JeuxDeDonneesConfig;

@ContextConfiguration(classes={ ServicesConfig.class, JeuxDeDonneesConfig.class})
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired
	private AvantageRepository avantageRepository;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
			
		Avantage nouveauAvantage = new Avantage(null, null, null);
		String codePush = "Avantage1";
		String nomPush = "Super Avantage";
		BigDecimal montantPush = new BigDecimal(200);
		
		nouveauAvantage.setCode(codePush);
		nouveauAvantage.setNom(nomPush);
		nouveauAvantage.setMontant(montantPush);
		avantageRepository.save(nouveauAvantage);
		
		assertThat(nouveauAvantage.getCode(), equalTo("Avantage1"));
		assertThat(nouveauAvantage.getNom(), equalTo("Super Avantage"));
		assertThat(nouveauAvantage.getMontant(), equalTo(new BigDecimal(200)));
		
		String codeEdit ="Avantage2";
		String nomEdit = "Super Avantage 2";
		BigDecimal montantEdit = new BigDecimal(8000);		
		
		avantageRepository.findByCode(codeEdit);
		nouveauAvantage.setCode(codeEdit);
		nouveauAvantage.setNom(nomEdit);
		nouveauAvantage.setMontant(montantEdit);
		avantageRepository.save(nouveauAvantage);
		
		assertThat(nouveauAvantage.getCode(), equalTo("Avantage2"));
		assertThat(nouveauAvantage.getNom(), equalTo("Super Avantage 2"));
		assertThat(nouveauAvantage.getMontant(), equalTo(new BigDecimal(8000)));
		
		
				
	}
}
