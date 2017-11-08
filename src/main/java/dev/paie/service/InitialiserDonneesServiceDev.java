package dev.paie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.UtilisateurRepository;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	private PeriodeRepository emPeriode;
	
@PersistenceContext EntityManager em;
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired private UtilisateurRepository emUtilisateur;
	
	@Override
	@Transactional
	public void initialiser() {
		
		String iciUnMotDePasse = "topSecret";
		String IciMotDePasseHashe = this.passwordEncoder.encode(iciUnMotDePasse);
		
		Stream.of(Cotisation.class, Entreprise.class, Grade.class, ProfilRemuneration.class, RemunerationEmploye.class)
		.forEach(classe -> 
		context.getBeansOfType(classe)
		.values()
		.stream()
		.forEach(object -> em.persist(object))
				);
		
		Utilisateur admin = new Utilisateur();
		admin.setNomUtilisateur("admin");
		admin.setMotDePasse(IciMotDePasseHashe);
		admin.setRole(ROLES.ROLE_ADMINISTRATEUR);
		admin.setEstActif(true);
		
		Utilisateur lambda = new Utilisateur();
		lambda.setNomUtilisateur("user");
		lambda.setMotDePasse(IciMotDePasseHashe);
		lambda.setRole(ROLES.ROLE_UTILISATEUR);
		lambda.setEstActif(true);
		
		emUtilisateur.save(admin);
		emUtilisateur.save(lambda);
		
		List<Periode> periodes = new ArrayList<>();
		
			periodes.add(new Periode(LocalDate.of(2017, 1, 1), LocalDate.of(2017, 1, 31)));
			periodes.add(new Periode(LocalDate.of(2017, 2, 1), LocalDate.of(2017, 2, 28)));
			periodes.add(new Periode(LocalDate.of(2017, 3, 1), LocalDate.of(2017, 3, 31)));
			periodes.add(new Periode(LocalDate.of(2017, 4, 1), LocalDate.of(2017, 4, 30)));
			periodes.add(new Periode(LocalDate.of(2017, 5, 1), LocalDate.of(2017, 5, 31)));
			periodes.add(new Periode(LocalDate.of(2017, 6, 1), LocalDate.of(2017, 6, 30)));
			periodes.add(new Periode(LocalDate.of(2017, 7, 1), LocalDate.of(2017, 7, 31)));
			periodes.add(new Periode(LocalDate.of(2017, 8, 1), LocalDate.of(2017, 8, 31)));
			periodes.add(new Periode(LocalDate.of(2017, 9, 1), LocalDate.of(2017, 9, 30)));
			periodes.add(new Periode(LocalDate.of(2017, 10, 1), LocalDate.of(2017, 10, 31)));
			periodes.add(new Periode(LocalDate.of(2017, 11, 1), LocalDate.of(2017, 11, 30)));
			periodes.add(new Periode(LocalDate.of(2017, 12, 1), LocalDate.of(2017, 12, 31)));
			periodes.stream().forEach(periode -> emPeriode.save(periode));
			
	}

}
