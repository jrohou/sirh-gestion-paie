package dev.paie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.PeriodeRepository;

public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	private PeriodeRepository emPeriode;
	
	@Autowired
	private List<Entreprise> entreprise1;
	
	@Autowired
	private List<Entreprise> entreprise2;
	
	@Autowired
	private List<Entreprise> entreprise3;
	
	@Autowired
	private List<Grade> grade1;
	
	@Autowired
	private List<Grade> grade2;
	
	@Autowired
	private List<Grade> grade3;
	
	@Autowired
	private List<ProfilRemuneration> profilTechnicien;
	
	@Autowired
	private List<ProfilRemuneration> profilCadre;
	
	@Autowired
	private List<ProfilRemuneration> profilStagiaire;
	
	@Autowired
	private List<Cotisation> sp01;
	
	@Autowired
	private List<Cotisation> sp02;
	
	@Autowired
	private ApplicationContext context;
	
	Map<String,Cotisation> cotisations = context.getBeansOfType(Cotisation.class);
	
	
	@Override
	public void initialiser() {
		
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
