package com.practice.gestion_st.Controller;

import com.practice.gestion_st.Dao.CategorieRepository;
import com.practice.gestion_st.Dao.FournisseurRepository;
import com.practice.gestion_st.Entity.Categorie;
import com.practice.gestion_st.Service.Imp.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategorieController {
	@Autowired
	CategorieService categorieService;

	@GetMapping("")
	public String categories_list(Model model) {
		model.addAttribute("categories", categorieService.findAll());
		return "categories/categories";
	}

	@GetMapping("/form_add")
	public String categories_add(Model model) {
		model.addAttribute("categorie", new Categorie());
		return "categories/categories_save";
	}

	@GetMapping("/form_update")
	public String categories_update(int id, Model model) {
		model.addAttribute("categorie", categorieService.findById(id));
		return "categories/categories_save";
	}

	@PostMapping("/save")
	public String categories_save(Categorie categorie, Model model) {
		categorieService.save(categorie);
		return "redirect:/categories";
	}
	@GetMapping("/delete")
	public String categories_delete(int id, Model model) {
		categorieService.deleteById(id);
		return "redirect:/categories";
	}
}
