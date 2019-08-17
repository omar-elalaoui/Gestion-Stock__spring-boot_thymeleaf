package com.practice.gestion_st.Service.Imp;

import com.practice.gestion_st.Dao.CommandeFournisseurRepository;
import com.practice.gestion_st.Entity.CommandeFournisseur;
import com.practice.gestion_st.Entity.LigneCommandeFournisseur;
import com.practice.gestion_st.Service.IcommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommandeFournisseurService implements IcommandeFournisseurService {

    @Autowired
    CommandeFournisseurRepository commandeFournisseurRepository;
    @Autowired
    ProduitService produitService;
    @Autowired
    LigneCommandeFournisseurService ligneCommandeFournisseurService;
    
    @Override
    public void save(CommandeFournisseur commandeFournisseur) {
        if(commandeFournisseur.getId() != 0){
            List<LigneCommandeFournisseur> lg_cmd_f= findById(commandeFournisseur.getId()).getLigneCommandes();
            ligneCommandeFournisseurService.deleteList(lg_cmd_f);
        }
        commandeFournisseur.getLigneCommandes().forEach(lc -> {lc.setCommandeFournisseur(commandeFournisseur);});
        commandeFournisseurRepository.save(commandeFournisseur);
    }
    
    @Override
    public void deleteById(Long id) {
        commandeFournisseurRepository.deleteById(id);
    }
    
    @Override
    public CommandeFournisseur findById(Long id) {
        if(!commandeFournisseurRepository.findById(id).isPresent()) {
            throw new RuntimeException("commande not found "+id);
        }
        return commandeFournisseurRepository.findById(id).get();
    }
    
    @Override
    public long getCmdMontant(CommandeFournisseur cf){
        long montant=0;
        for(LigneCommandeFournisseur lgF: cf.getLigneCommandes()){
            montant+= lgF.getQuantite()* produitService.findById(lgF.getProduit().getId()).getPrix_unitaire();
        }
        return montant;
    }
    
    @Override
    public long getCmdsMontant(List<CommandeFournisseur> cmdsF){
        return cmdsF.stream().mapToLong(CommandeFournisseur::getMontant).sum();
    }
    
    @Override
    public CommandeFournisseur cleanCommande(CommandeFournisseur cf){
        List<LigneCommandeFournisseur> lgC= new ArrayList<LigneCommandeFournisseur>();
        cf.getLigneCommandes().forEach(lc -> {
            if(lc.getProduit() != null) lgC.add(lc);
        });
        cf.setLigneCommandes(lgC);
        return cf;
    }
    
    @Override
    public List<CommandeFournisseur> findAll() {
        return commandeFournisseurRepository.findAll();
    }
    @Override
    public List<CommandeFournisseur> findByDateBetween(Date d1, Date d2) {
        return commandeFournisseurRepository.findByDateBetween(d1, d2);
    }
}
