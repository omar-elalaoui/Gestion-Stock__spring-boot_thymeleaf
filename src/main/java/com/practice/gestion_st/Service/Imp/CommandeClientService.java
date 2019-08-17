package com.practice.gestion_st.Service.Imp;

import com.practice.gestion_st.Dao.CommandeClientRepository;
import com.practice.gestion_st.Entity.CommandeClient;
import com.practice.gestion_st.Entity.LigneCommandeClient;
import com.practice.gestion_st.Service.IcommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommandeClientService implements IcommandeClientService {
    @Autowired
    CommandeClientRepository commandeClientRepository;
    @Autowired
    ProduitService produitService;
    @Autowired
    LigneCommandeClientService ligneCommandeClientService;
    
    @Override
    public void save(CommandeClient commandeClient) {
        if(commandeClient.getId() != 0){
            List<LigneCommandeClient> lg_cmd_c= findById(commandeClient.getId()).getLigneCommandes();
            ligneCommandeClientService.deleteList(lg_cmd_c);
        }
        commandeClient.getLigneCommandes().forEach(lc -> {lc.setCommandeClient(commandeClient);});
        commandeClientRepository.save(commandeClient);
    }

    @Override
    public void deleteById(Long id) {
        commandeClientRepository.deleteById(id);
    }

    @Override
    public CommandeClient findById(Long id) {
        if(!commandeClientRepository.findById(id).isPresent()) {
            throw new RuntimeException("commande not found "+id);
        }
        return commandeClientRepository.findById(id).get();
    }
    
    @Override
    public long getCmdMontant(CommandeClient cf){
        long montant=0;
        for(LigneCommandeClient lgC: cf.getLigneCommandes()){
            montant+= lgC.getQuantite()* produitService.findById(lgC.getProduit().getId()).getPrix_unitaire();
        }
        return montant;
    }
    
    @Override
    public long getCmdsMontant(List<CommandeClient> cmdsF){
        return cmdsF.stream().mapToLong(CommandeClient::getMontant).sum();
    }
    
    @Override
    public List<CommandeClient> findByDateBetween(Date d1, Date d2) {
        return commandeClientRepository.findByDateBetween(d1, d2);
    }
    
    @Override
    public CommandeClient cleanCommande(CommandeClient cf){
        List<LigneCommandeClient> lgC= new ArrayList<LigneCommandeClient>();
        cf.getLigneCommandes().forEach(lc -> {
            if(lc.getProduit() != null) lgC.add(lc);
        });
        cf.setLigneCommandes(lgC);
        return cf;
    }
    
    @Override
    public List<CommandeClient> findAll() {
        return commandeClientRepository.findAll();
    }
}
