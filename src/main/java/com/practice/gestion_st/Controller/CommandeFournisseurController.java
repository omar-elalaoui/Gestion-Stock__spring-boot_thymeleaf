package com.practice.gestion_st.Controller;

import com.practice.gestion_st.Entity.CommandeFournisseur;
import com.practice.gestion_st.Entity.Fournisseur;
import com.practice.gestion_st.Entity.LigneCommandeFournisseur;
import com.practice.gestion_st.Service.Imp.CommandeFournisseurService;
import com.practice.gestion_st.Service.Imp.FournisseurService;
import com.practice.gestion_st.Service.Imp.LigneCommandeFournisseurService;
import com.practice.gestion_st.Service.Imp.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/entrees")
public class CommandeFournisseurController {

    @Autowired
    CommandeFournisseurService commandeFournisseurService;
    @Autowired
    LigneCommandeFournisseurService ligneCommandeFournisseurService;
    @Autowired
    FournisseurService fournisseurService;
    @Autowired
    ProduitService produitService;

    @GetMapping("")
    public String entrees(Model model) {
        model.addAttribute("commandes_fournisseur",commandeFournisseurService.findAll());
        return "entrees/entrees";
    }

    @GetMapping("/nouvelle_commande")
    public String entree_form(Model model) {
        ArrayList<LigneCommandeFournisseur> lignesCommandes= new ArrayList<LigneCommandeFournisseur>();
        CommandeFournisseur commandeFournisseur= new CommandeFournisseur();
        commandeFournisseur.setFournisseur(new Fournisseur());
        commandeFournisseur.setLigneCommandes(lignesCommandes);
        model.addAttribute("commande_fournisseur", commandeFournisseur);
        model.addAttribute("produits", produitService.findAll());
        model.addAttribute("fournisseurs",fournisseurService.findAll());
        return "entrees/entrees_save";
    }

    @GetMapping("/save")
    public String save(CommandeFournisseur commandeFournisseur, Model model){
        commandeFournisseur= commandeFournisseurService.cleanCommande(commandeFournisseur);
        commandeFournisseur.setMontant(commandeFournisseurService.getCmdMontant(commandeFournisseur));
        if(commandeFournisseur.getId() != 0){
            List<LigneCommandeFournisseur> lg_cmd_f= commandeFournisseurService.findById(commandeFournisseur.getId()).getLigneCommandes();
            ligneCommandeFournisseurService.deleteList(lg_cmd_f);
        }
        commandeFournisseurService.save(commandeFournisseur);
        return "redirect:/entrees";
    }
    
    @GetMapping("/update")
    public String update(Long id, Model model){
        model.addAttribute("fournisseurs", fournisseurService.findAll());
        model.addAttribute("produits", produitService.findAll());
        model.addAttribute("commande_fournisseur", commandeFournisseurService.findById(id));
        return "/entrees/entrees_save";
    }
    @GetMapping("/details")
    public String details(Long id, Model model){
        model.addAttribute("commande_fournisseur", commandeFournisseurService.findById(id));
        return "/entrees/entrees_det";
    }
    @GetMapping("/delete")
    public String delete(Long id, Model model){
        commandeFournisseurService.deleteById(id);
        return "redirect:/entrees";
    }

}
