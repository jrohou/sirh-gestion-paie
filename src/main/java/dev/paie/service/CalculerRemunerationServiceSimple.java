package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	
	@Autowired
	PaieUtils paieutils;
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration result = new ResultatCalculRemuneration();
		
		 String salaire_base = paieutils.formaterBigDecimal(bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase()));
		 
		 String salaire_brut = paieutils.formaterBigDecimal(new BigDecimal(salaire_base).add(bulletin.getPrimeExceptionnelle()));
		 
		 String total_retenue_salariale = paieutils.formaterBigDecimal(bulletin.getRemunerationEmploye()
				 .getProfilRemuneration()
				 .getCotisationsNonImposables().stream()
				 .filter(cotisation -> cotisation.getTauxSalarial() != null)
				 .map(cotisation -> cotisation.getTauxSalarial().multiply(new BigDecimal(salaire_brut)))
				 .reduce((cotisation,cotisation1)-> cotisation.add(cotisation1))
				 .get());
		 
		 
		 
		 String total_cotisations_patronales = paieutils.formaterBigDecimal(bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				 .filter(cotisationpatro -> cotisationpatro.getTauxPatronal() != null)
				 .map(cotisationpatro -> cotisationpatro.getTauxPatronal().multiply(new BigDecimal(salaire_brut)))
				 .reduce((cotisationpatro,cotisationpatro1)-> cotisationpatro.add(cotisationpatro1)).get());
		 
		 String net_imposable = paieutils.formaterBigDecimal(new BigDecimal(salaire_brut).subtract(new BigDecimal(total_retenue_salariale)));
		 
		 String net_a_payer = paieutils.formaterBigDecimal(new BigDecimal(net_imposable).subtract(bulletin.getRemunerationEmploye()
				 .getProfilRemuneration()
				 .getCotisationsImposables().stream()
				 .filter(cotisation -> cotisation.getTauxSalarial() != null)
				 .map(cotisation -> cotisation.getTauxSalarial().multiply(new BigDecimal(salaire_brut)))
				 .reduce((cotisation,cotisation1)-> cotisation.add(cotisation1)).get()));
		 
		 result.setSalaireDeBase(salaire_base);
		 result.setSalaireBrut(salaire_brut);
		 result.setTotalRetenueSalarial(total_retenue_salariale);
		 result.setTotalCotisationsPatronales(total_cotisations_patronales);
		 result.setNetImposable(net_imposable);
		 result.setNetAPayer(net_a_payer);
		 
		 return result;
	}

}
