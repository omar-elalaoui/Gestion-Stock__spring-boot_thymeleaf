package com.practice.gestion_st.Controller;

import com.practice.gestion_st.Entity.CommandeClient;
import com.practice.gestion_st.Entity.CommandeFournisseur;
import com.practice.gestion_st.Service.Imp.CommandeClientService;
import com.practice.gestion_st.Service.Imp.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    CommandeFournisseurService commandeFournisseurService;
    @Autowired
    CommandeClientService commandeClientService;
    long montant_f, montant_c;
    
    @GetMapping("")
    public String journal(Model model){
        
        List<CommandeFournisseur> cmdsF= commandeFournisseurService.findAll();
        montant_f= commandeFournisseurService.getCmdsMontant(cmdsF);
        List<CommandeClient> cmdsC= commandeClientService.findAll();
        montant_c= commandeClientService.getCmdsMontant(cmdsC);
        
        model.addAttribute("commandes_fournisseur", cmdsF);
        model.addAttribute("commandes_client", cmdsC);
        model.addAttribute("montant_f", montant_f);
        model.addAttribute("montant_c", montant_c);
        return "journal";
    }
    
    @GetMapping("/extrait")
    public String sous_journal(Date d1, Date d2, Model model){
        
        List<CommandeFournisseur> cmdsF= commandeFournisseurService.findByDateBetween(d1, d2);
        montant_f= commandeFournisseurService.getCmdsMontant(cmdsF);
        List<CommandeClient> cmdsC= commandeClientService.findByDateBetween(d1, d2);
        montant_c= commandeClientService.getCmdsMontant(cmdsC);
        
        model.addAttribute("commandes_fournisseur", cmdsF);
        model.addAttribute("commandes_client", cmdsC);
        model.addAttribute("montant_f", montant_f);
        model.addAttribute("montant_c", montant_c);
        return "journal";
    }
    
}
