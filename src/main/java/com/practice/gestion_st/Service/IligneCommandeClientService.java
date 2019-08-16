package com.practice.gestion_st.Service;

import com.practice.gestion_st.Entity.LigneCommandeClient;

import java.util.List;

public interface IligneCommandeClientService {
    public void save(LigneCommandeClient ligneCommandeClient);
    public void deleteById(Long id);
    public LigneCommandeClient findById(Long id);
    public List<LigneCommandeClient> findAll();
}
