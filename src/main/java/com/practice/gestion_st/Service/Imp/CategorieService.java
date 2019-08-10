package com.practice.gestion_st.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.practice.gestion_st.Dao.CategorieRepository;
import com.practice.gestion_st.Entity.Categorie;
import com.practice.gestion_st.Service.IcategorieService;
import org.springframework.stereotype.Service;

@Service
public class CategorieService implements IcategorieService {

	final
	CategorieRepository categorieRepository;

	public CategorieService(CategorieRepository categorieRepository) {
		this.categorieRepository = categorieRepository;
	}

	@Override
	public List<Categorie> findAll() {
		return categorieRepository.findAll();
	}
	
	@Override
	public void save(Categorie p) {
		categorieRepository.save(p);
	}

	@Override
	public void deleteById(int id) {
		categorieRepository.deleteById(id);

	}

	@Override
	public Categorie findById(int id) {
		if(!categorieRepository.findById(id).isPresent()) {
			throw new RuntimeException("produit not found "+id);
		}
		return categorieRepository.findById(id).get();
	}


}
