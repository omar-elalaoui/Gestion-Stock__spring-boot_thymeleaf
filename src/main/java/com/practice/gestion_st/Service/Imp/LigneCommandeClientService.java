package com.practice.gestion_st.Service.Imp;

import com.practice.gestion_st.Dao.LigneCommandeClientRepository;
import com.practice.gestion_st.Entity.LigneCommandeClient;
import com.practice.gestion_st.Service.IligneCommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeClientService implements IligneCommandeClientService {
    @Autowired
    LigneCommandeClientRepository ligneCommandeClientRepository;

    @Override
    public void save(LigneCommandeClient ligneCommandeClient) {
        ligneCommandeClientRepository.save(ligneCommandeClient);
    }

    @Override
    public void deleteById(Long id) {
        ligneCommandeClientRepository.deleteById(id);
    }

    @Override
    public LigneCommandeClient findById(Long id) {
        if(!ligneCommandeClientRepository.findById(id).isPresent()) {
            throw new RuntimeException("ligne commande not found "+id);
        }
        return ligneCommandeClientRepository.findById(id).get();
    }

    @Override
    public List<LigneCommandeClient> findAll() {
        return ligneCommandeClientRepository.findAll();
    }
}
