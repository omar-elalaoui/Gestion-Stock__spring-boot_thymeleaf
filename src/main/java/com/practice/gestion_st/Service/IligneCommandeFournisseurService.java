package com.practice.gestion_st.Service;

import com.practice.gestion_st.Entity.LigneCommandeFournisseur;

import java.util.List;

public interface IligneCommandeFournisseurService {
    public void save(LigneCommandeFournisseur ligneCommandeFournisseur);
    public void deleteById(Long id);
    public void deleteList(List<LigneCommandeFournisseur> ligneCommandeFournisseurs);
    public LigneCommandeFournisseur findById(Long id);
    public List<LigneCommandeFournisseur> findAll();
}
