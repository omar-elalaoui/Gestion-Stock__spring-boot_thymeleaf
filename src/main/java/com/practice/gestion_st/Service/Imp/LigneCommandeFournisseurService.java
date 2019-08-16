package com.practice.gestion_st.Service.Imp;

import com.practice.gestion_st.Dao.LigneCommandeFournisseurRespository;
import com.practice.gestion_st.Entity.LigneCommandeFournisseur;
import com.practice.gestion_st.Service.IligneCommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeFournisseurService implements IligneCommandeFournisseurService {
    @Autowired
    LigneCommandeFournisseurRespository ligneCommandeFournisseurRespository;

    @Override
    public void save(LigneCommandeFournisseur ligneCommandeFournisseur) {
        ligneCommandeFournisseurRespository.save(ligneCommandeFournisseur);
    }

    @Override
    public void deleteById(Long id) {
        ligneCommandeFournisseurRespository.deleteById(id);
    }
    
    @Override
    public void deleteList(List<LigneCommandeFournisseur> ligneCommandeFournisseurs) {
        ligneCommandeFournisseurs.forEach(lg -> {
            lg.setCommandeFournisseur(null);
            save(lg);
            deleteById(lg.getId());
        });
    }

    @Override
    public LigneCommandeFournisseur findById(Long id) {
        if(!ligneCommandeFournisseurRespository.findById(id).isPresent()) {
            throw new RuntimeException("ligne commande not found "+id);
        }
        return ligneCommandeFournisseurRespository.findById(id).get();
    }

    @Override
    public List<LigneCommandeFournisseur> findAll() {
        return ligneCommandeFournisseurRespository.findAll();
    }
}
