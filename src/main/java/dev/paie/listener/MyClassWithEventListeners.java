package dev.paie.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.paie.service.InitialiserDonneesService;
import dev.paie.service.InitialiserDonneesServiceDev;

@Component
public class MyClassWithEventListeners {

	@Autowired
	InitialiserDonneesService inits;
	 @EventListener({ContextRefreshedEvent.class})
	    void contextRefreshedEvent() {
//		 	inits.initialiser();
	    }
	}

