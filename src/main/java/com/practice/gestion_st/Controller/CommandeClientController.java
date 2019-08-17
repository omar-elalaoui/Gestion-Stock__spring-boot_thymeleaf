package com.practice.gestion_st.Controller;

import com.practice.gestion_st.Entity.Client;
import com.practice.gestion_st.Entity.CommandeClient;
import com.practice.gestion_st.Entity.LigneCommandeClient;
import com.practice.gestion_st.Service.Imp.ClientService;
import com.practice.gestion_st.Service.Imp.CommandeClientService;
import com.practice.gestion_st.Service.Imp.LigneCommandeClientService;
import com.practice.gestion_st.Service.Imp.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/sorties")
public class CommandeClientController {
    @Autowired
    CommandeClientService commandeClientService;
    @Autowired
    LigneCommandeClientService ligneCommandeClientService;
    @Autowired
    ProduitService produitService;
    @Autowired
    ClientService clientService;
    
    @GetMapping("")
    public String sorties(Model model) {
        model.addAttribute("commandes_client", commandeClientService.findAll());
        return "sorties/sorties";
    }
    
    @GetMapping("/nouvelle_commande")
    public String sorties_form(Model model) {
        ArrayList<LigneCommandeClient> lignesCommandes= new ArrayList<LigneCommandeClient>();
        CommandeClient commandeClient= new CommandeClient();
        commandeClient.setClient(new Client());
        commandeClient.setLigneCommandes(lignesCommandes);
        model.addAttribute("commande_client", commandeClient);
        model.addAttribute("produits", produitService.findAll());
        model.addAttribute("clients",clientService.findAll());
        return "sorties/sorties_save";
    }
    
    @GetMapping("/save")
    public String save(CommandeClient commandeClient){
        commandeClient= commandeClientService.cleanCommande(commandeClient);
        commandeClient.setMontant(commandeClientService.getCmdMontant(commandeClient));
        commandeClientService.save(commandeClient);
        return "redirect:/sorties";
    }
    
    @GetMapping("/update")
    public String update(long id, Model model){
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("produits", produitService.findAll());
        model.addAttribute("commande_fournisseur", commandeClientService.findById(id));
        return "/sorties/sorties_save";
    }
    @GetMapping("/details")
    public String details(long id, Model model){
        model.addAttribute("commande_client", commandeClientService.findById(id));
        return "/sorties/sorties_det";
    }
    @GetMapping("/delete")
    public String delete(long id, Model model){
        commandeClientService.deleteById(id);
        return "redirect:/sorties";
    }
    
    @GetMapping("/facture")
    public String facture_vente(long id, Model model){
        model.addAttribute("commande", commandeClientService.findById(id));
        return "facture";
    }
    @GetMapping("/facture_print")
    public String facture_prin(long id, Model model){
        model.addAttribute("commande", commandeClientService.findById(id));
        return "facture_print";
    }

}
