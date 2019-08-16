package com.practice.gestion_st.Controller;

import com.practice.gestion_st.Entity.Fournisseur;
import com.practice.gestion_st.Service.Imp.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fournisseurs")
public class FournisseurController {

	@Autowired
	FournisseurService fournisseurService;
	@GetMapping("")
	public String fournisseurs(Model modal) {
		modal.addAttribute("fournisseurs", fournisseurService.findAll());
		return "fournisseurs/fournisseurs";
	}

	@GetMapping("/form_add")
	public String fournisseurs_form(Model modal) {
		modal.addAttribute("fournisseur", new Fournisseur());
		return "fournisseurs/fournisseurs_save";
	}

	@GetMapping("/form_update")
	public String fournisseurs_form(int id, Model modal) {
		modal.addAttribute("fournisseur", fournisseurService.findById(id));
		return "fournisseurs/fournisseurs_save";
	}

	@PostMapping("/save")
	public String fournisseurs_save(Fournisseur fournisseur, Model modal) {
		fournisseurService.save(fournisseur);
		return "redirect:/fournisseurs";
	}

	@GetMapping("/delete")
	public String fournisseurs_delete(int id) {
		fournisseurService.deleteById(id);
		return "redirect:/fournisseurs";
	}

	

	
	@GetMapping("/facture_achat")
	public String facture_achat(Model modal) {
		return "facture_achat";
	}
	
}
