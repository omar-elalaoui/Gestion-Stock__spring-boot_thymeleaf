package com.practice.gestion_st.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/accueil")
	public String accueil(Model modal) {
		return "accueil";
	}
	
	@GetMapping("/categories")
	public String categories(Model modal) {
		return "categories";
	}
	
	@GetMapping("/produits")
	public String produits(Model modal) {
		return "produits";
	}

	@GetMapping("/clients")
	public String clients(Model modal) {
		return "clients";
	}
	
	@GetMapping("/fournisseurs")
	public String fournisseurs(Model modal) {
		return "fournisseurs";
	}
	
	@GetMapping("/entrees")
	public String entrees(Model modal) {
		return "entrees";
	}
	
	@GetMapping("/sorties")
	public String sorties(Model modal) {
		return "sorties";
	}
	
	@GetMapping("/facture_achat")
	public String facture_achat(Model modal) {
		return "facture_achat";
	}
	
	@GetMapping("/facture_vente")
	public String facture_vente(Model modal) {
		return "facture_vente";
	}
	
	@GetMapping("/journal")
	public String journal(Model modal) {
		return "journal";
	}
	
	@GetMapping("/utilisateurs")
	public String utilisateurs(Model modal) {
		return "utilisateurs";
	}
}
