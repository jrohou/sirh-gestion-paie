package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Service
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional (timeout = 60)
	public void sauvegarder(Cotisation nouvelleCotisation) {

		em.persist(nouvelleCotisation);
		
	}

	@Override
	@Transactional (timeout = 60)
	public void mettreAJour(Cotisation cotisation) {
		
		em.merge(cotisation);
		
	}

	@Override
	@Transactional (timeout = 60)
	public List<Cotisation> lister() {
		
		TypedQuery<Cotisation> queryf = em.createQuery("From cotisation",Cotisation.class);
		
		return queryf.getResultList();
	
	}
	
}
