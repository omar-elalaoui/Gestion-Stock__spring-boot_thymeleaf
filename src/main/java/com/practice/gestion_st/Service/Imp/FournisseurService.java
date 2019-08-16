package com.practice.gestion_st.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.practice.gestion_st.Dao.FournisseurRepository;
import com.practice.gestion_st.Entity.Fournisseur;
import com.practice.gestion_st.Service.IfournisseurService;
import org.springframework.stereotype.Service;

@Service
public class FournisseurService implements IfournisseurService {

	@Autowired
	FournisseurRepository fournisseurRepository;

	
	@Override
	public List<Fournisseur> findAll() {
		return fournisseurRepository.findAll();
	}
	
	@Override
	public void save(Fournisseur p) {
		fournisseurRepository.save(p);
	}

	@Override
	public void deleteById(int id) {
		fournisseurRepository.deleteById(id);

	}

	@Override
	public Fournisseur findById(int id) {
		if(!fournisseurRepository.findById(id).isPresent()) {
			throw new RuntimeException("fournisseur not found "+id);
		}
		return fournisseurRepository.findById(id).get();
	}

}
