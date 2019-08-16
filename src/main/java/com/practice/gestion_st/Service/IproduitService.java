package com.practice.gestion_st.Service;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.practice.gestion_st.Entity.Produit;
import org.springframework.web.multipart.MultipartFile;

public interface IproduitService {
	public void save(Produit p);
	public void save(Produit p, MultipartFile pic) throws IOException;
	public void deleteById(Long id);
	public Produit findById(Long id);
	public byte[] findImageById(Long id) throws IOException;
	public List<Produit> findAll();
}
