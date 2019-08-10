package com.practice.gestion_st.Service;

import java.util.List;

import com.practice.gestion_st.Entity.Fournisseur;

public interface IfournisseurService {
	public void save(Fournisseur p);
	public void deleteById(int id);
	public Fournisseur findById(int id);
	public List<Fournisseur> findAll();
}
