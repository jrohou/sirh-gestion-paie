package dev.paie.web.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/bulletin")
public class BulletinSalaireController {

	@Autowired
	BulletinSalaireRepository listeBulletinSalaire;
	
	@Autowired
	PeriodeRepository listePeriode;
	
	@Autowired
	RemunerationEmployeRepository listeEmploye;
	
	@RequestMapping (method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletin/creerBulletin");
		mv.addObject("listePeriode",listePeriode.findAll());
		mv.addObject("listeEmploye",listeEmploye.findAll());
		return mv;
	}
	
	@RequestMapping (method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletin/lister");
		mv.addObject("listerBulletin", listeBulletinSalaire.findAll());
		
		return mv;
	}
	
	@RequestMapping (method = RequestMethod.POST, path="/lister")
	public ModelAndView creerBulletin(int matricule, int periode, BigDecimal prime) {
		ModelAndView mv = new ModelAndView();
		BulletinSalaire nouveauBulletin = new BulletinSalaire();
		nouveauBulletin.setRemunerationEmploye(listeEmploye.findOne(matricule));
		nouveauBulletin.setPeriode(listePeriode.findOne(periode));
		nouveauBulletin.setPrimeExceptionnelle(prime);
		
		listeBulletinSalaire.save(nouveauBulletin);
		
		mv.setViewName("bulletin/lister");
		
		
		return mv;
	}
}
