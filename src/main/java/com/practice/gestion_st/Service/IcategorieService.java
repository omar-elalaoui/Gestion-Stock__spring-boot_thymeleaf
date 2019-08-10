package com.practice.gestion_st.Service;

import java.util.List;

import com.practice.gestion_st.Entity.Categorie;

public interface IcategorieService {
	public void save(Categorie p);
	public void deleteById(int id);
	public Categorie findById(int id);
	public List<Categorie> findAll();
}
