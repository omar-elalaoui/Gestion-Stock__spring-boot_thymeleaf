package com.practice.gestion_st.Controller;

import com.practice.gestion_st.Entity.Fournisseur;
import com.practice.gestion_st.Service.Imp.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FournisseurController {

	@Autowired
	FournisseurService fournisseurService;
	@GetMapping("/fournisseurs")
	public String fournisseurs(Model modal) {
		modal.addAttribute("fournisseurs", fournisseurService.findAll());
		return "fournisseurs/fournisseurs";
	}

	@GetMapping("/fournisseurs/form_add")
	public String fournisseurs_form(Model modal) {
		modal.addAttribute("fournisseur", new Fournisseur());
		return "fournisseurs/fournisseurs_save";
	}

	@GetMapping("/fournisseurs/form_update")
	public String fournisseurs_form(int id, Model modal) {
		modal.addAttribute("fournisseur", fournisseurService.findById(id));
		return "fournisseurs/fournisseurs_save";
	}

	@PostMapping("/fournisseurs/save")
	public String fournisseurs_save(Fournisseur fournisseur, Model modal) {
		fournisseurService.save(fournisseur);
		return "redirect:/fournisseurs";
	}

	@GetMapping("/fournisseurs/delete")
	public String fournisseurs_delete(int id) {
		fournisseurService.deleteById(id);
		return "redirect:/fournisseurs";
	}

	
	@GetMapping("/entrees")
	public String entrees(Model modal) {
		return "entrees/entrees";
	}
	
	@GetMapping("/entrees/nouvelle_commande")
	public String entree_form(Model modal) {
		return "entrees/entrees_save";
	}
	
	@GetMapping("/facture_achat")
	public String facture_achat(Model modal) {
		return "facture_achat";
	}
	
}
