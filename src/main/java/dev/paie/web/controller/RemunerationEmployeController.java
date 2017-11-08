package dev.paie.web.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired
	RemunerationEmployeRepository listeEmploye;
	
	@Autowired
	EntrepriseRepository listeEntreprise;
	
	@Autowired
	ProfilRemunerationRepository listeProfil;
	
	@Autowired
	GradeRepository listeGrade;

	@RequestMapping (method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("listeEntreprise",listeEntreprise.findAll());
		mv.addObject("listeProfil",listeProfil.findAll());
		mv.addObject("listeGrade",listeGrade.findAll());
		return mv;
	}
	
	@RequestMapping (method = RequestMethod.GET, path = "/lister")
	@Secured({"ROLE_UTILISATEUR","ROLE_ADMINISTRATEUR"})
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/lister");
		mv.addObject("listerEmployes",listeEmploye.findAll());
	
		
		return mv;
	}
	
	@RequestMapping (method = RequestMethod.POST, path="/lister")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmploye (String matricule,int entreprise, int profil, int grade) {
		ModelAndView mv = new ModelAndView();
		RemunerationEmploye nouveauEmploye = new RemunerationEmploye();
		nouveauEmploye.setMatricule(matricule);
		nouveauEmploye.setEntreprise(listeEntreprise.findOne(entreprise));
		nouveauEmploye.setProfilRemuneration(listeProfil.findOne(profil));
		nouveauEmploye.setGrade(listeGrade.findOne(grade));
		nouveauEmploye.setCreationDate(LocalDate.now());
		
		listeEmploye.save(nouveauEmploye);
		
		mv.setViewName("employes/lister");
		mv.addObject("matricule",matricule);
		mv.addObject("entreprise",listeEntreprise.findOne(entreprise));
		mv.addObject("profil",listeProfil.findOne(profil));
		mv.addObject("grade",listeGrade.findOne(grade));
		mv.addObject("listerEmployes",listeEmploye.findAll());
		
		
		return mv;
		
	}
}
