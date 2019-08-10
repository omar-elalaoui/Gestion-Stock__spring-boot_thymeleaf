package com.practice.gestion_st.Service;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.practice.gestion_st.Entity.Produit;
import org.springframework.web.multipart.MultipartFile;

public interface IproduitService {
	public void save(Produit p);
	public void save(Produit p, MultipartFile pic) throws IOException;
	public void deleteById(int id);
	public Produit findById(int id);
	public byte[] findImageById(int id) throws IOException;
	public List<Produit> findAll();
}
