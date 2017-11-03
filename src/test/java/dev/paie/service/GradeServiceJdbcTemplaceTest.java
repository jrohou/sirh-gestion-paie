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
import dev.paie.entite.Grade;

@ContextConfiguration(classes={ ServicesConfig.class, JeuxDeDonneesConfig.class})
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplaceTest {

	@Autowired
	private GradeService gradeService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour () {
		
		Grade nouveauGrade = new Grade();
		String codePush = "GENERAL";
		BigDecimal nbHeuresBasePush = new BigDecimal(20);
		BigDecimal tauxBasePush = new BigDecimal(8);
		
		nouveauGrade.setCode(codePush);
		nouveauGrade.setNbHeuresBase(nbHeuresBasePush);
		nouveauGrade.setTauxBase(tauxBasePush);
		gradeService.sauvegarder(nouveauGrade);
		
		assertThat(nouveauGrade.getCode(), equalTo("GENERAL"));
		assertThat(nouveauGrade.getNbHeuresBase(), equalTo(new BigDecimal(20)));
		assertThat(nouveauGrade.getTauxBase(), equalTo(new BigDecimal(8)));
		
		String codeEdit = "Captain";
		BigDecimal nbHeuresBaseEdit = new BigDecimal(50);
		BigDecimal tauxBaseEdit = new BigDecimal(200);
		Integer idEdit = new Integer (1);
		
		nouveauGrade.setCode(codeEdit);
		nouveauGrade.setNbHeuresBase(nbHeuresBaseEdit);
		nouveauGrade.setTauxBase(tauxBaseEdit);
		nouveauGrade.setId(idEdit);
		gradeService.mettreAJour(nouveauGrade);
		
		assertThat(nouveauGrade.getCode(), equalTo("Captain"));
		assertThat(nouveauGrade.getNbHeuresBase(), equalTo(new BigDecimal(50)));
		assertThat(nouveauGrade.getTauxBase(), equalTo(new BigDecimal(200)));
		
		gradeService.lister();
	}
}
