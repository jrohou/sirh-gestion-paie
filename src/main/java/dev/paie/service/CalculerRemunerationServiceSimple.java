package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration result = new ResultatCalculRemuneration();
		
		 BigDecimal salaire_base = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		 
		 BigDecimal salaire_brut = salaire_base.add(bulletin.getPrimeExceptionnelle());
		 
		 BigDecimal total_retenue_salariale = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				 .filter(cotisation -> cotisation.getTauxSalarial() != null)
				 .map(cotisation -> cotisation.getTauxSalarial().multiply(salaire_brut))
				 .reduce((cotisation,cotisation1)-> cotisation.add(cotisation1)).get();
		 
		 BigDecimal total_cotisations_patronales = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				 .filter(cotisationpatro -> cotisationpatro.getTauxPatronal() != null)
				 .map(cotisationpatro -> cotisationpatro.getTauxPatronal().multiply(salaire_brut))
				 .reduce((cotisationpatro,cotisationpatro1)-> cotisationpatro.add(cotisationpatro1)).get();
		 
		 BigDecimal net_imposable = salaire_brut.subtract(total_retenue_salariale);
		 
		 BigDecimal net_a_payer = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().stream()
				 .filter(cotisation -> cotisation.getTauxSalarial() != null)
				 .map(cotisation -> cotisation.getTauxSalarial().multiply(salaire_brut))
				 .reduce((cotisation,cotisation1)-> cotisation.subtract(cotisation1)).get();
		 
		 //TODO String to BigDecimal
		 
		 
		 return result;
	}

}
