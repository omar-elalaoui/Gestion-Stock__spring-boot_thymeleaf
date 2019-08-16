package com.practice.gestion_st.Service;

import com.practice.gestion_st.Entity.CommandeFournisseur;

import java.util.List;

public interface IcommandeFournisseurService {
    public void save(CommandeFournisseur commandeFournisseur);
    public void deleteById(Long id);
    public CommandeFournisseur findById(Long id);
    public List<CommandeFournisseur> findAll();
}
