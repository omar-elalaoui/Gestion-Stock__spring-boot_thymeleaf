package com.practice.gestion_st.Controller;

import com.practice.gestion_st.Service.Imp.CategorieService;
import com.practice.gestion_st.Service.Imp.FournisseurService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.practice.gestion_st.Entity.Produit;
import com.practice.gestion_st.Service.Imp.ProduitService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/produits")
public class ProduitController {

	@Autowired
	ProduitService produitService;
	@Autowired
	FournisseurService fournisseurService;
	@Autowired
	CategorieService categorieService;

	@GetMapping("")
	public String produits(Model modal) {
		modal.addAttribute("produits", produitService.findAll());
		return "produits/produits";
	}
	@GetMapping("/details")
	public String produits_details(Model modal) {
		return "produits/produits_det";
	}

	@GetMapping("/form_add")
	public String produits_form_add(Model model) {
		model.addAttribute("produit", new Produit());
		model.addAttribute("fournisseurs", fournisseurService.findAll());
		model.addAttribute("categories", categorieService.findAll());
		return "produits/produits_save";
	}

	@GetMapping("/form_update")
	public String produits_form_update(int id, Model model) {
		model.addAttribute("produit", produitService.findById(id));
		model.addAttribute("fournisseurs", fournisseurService.findAll());
		model.addAttribute("categories", categorieService.findAll());
		return "produits/produits_save";
	}

	@PostMapping("/save")
	public String produits_save(Produit produit, @RequestParam(name = "pic") MultipartFile image, Model modal) throws IOException {
		if(!image.isEmpty()) { produitService.save(produit, image);
		}else{ produitService.save(produit); }
		return "redirect:/produits";
	}

	@RequestMapping(value = "/getPic", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPic(int id) throws IOException {
		return produitService.findImageById(id);
	}

	@GetMapping("/delete")
	public String produits_delete(int id) {
		produitService.deleteById(id);
		return "redirect:/produits";
	}
}
