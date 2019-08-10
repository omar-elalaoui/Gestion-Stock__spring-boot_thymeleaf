package com.practice.gestion_st.Service.Imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.practice.gestion_st.Dao.ProduitRepository;
import com.practice.gestion_st.Entity.Produit;
import com.practice.gestion_st.Service.IproduitService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProduitService implements IproduitService {
	@Value("${dir.produits}")
	String produitsDirPath;

	@Autowired
	ProduitRepository produitRepo;
	
	@Override
	public List<Produit> findAll() {
		return produitRepo.findAll();
	}
	
	@Override
	public void save(Produit p) {
		produitRepo.save(p);
	}
	@Override
	public void save(Produit produit, MultipartFile pic) throws IOException {
		File produitDir= new File(produitsDirPath);
		if(!produitDir.exists()) produitDir.mkdir();
		produit.setImage(pic.getOriginalFilename());
		produitRepo.save(produit);
		pic.transferTo(new File(produitsDirPath+"/"+produit.getId()));

	}

	@Override
	public void deleteById(int id) {
		File file=new File(produitsDirPath+"/"+id);
		if(file.exists()){
			if(file.delete()){ System.out.println("File deleted successfully");
			}else{ System.out.println("Fail to delete file"); }
		}
		produitRepo.deleteById(id);
	}

	@Override
	public Produit findById(int id) {
		if(!produitRepo.findById(id).isPresent()) {
			throw new RuntimeException("produit not found "+id);
		}
		return produitRepo.findById(id).get();
	}

	@Override
	public byte[] findImageById(int id) throws IOException {
		File image= new File(produitsDirPath+"/"+id);
		FileInputStream inputStream= new FileInputStream(image);
		byte[] imgb= IOUtils.toByteArray(inputStream);
		inputStream.close();
		return imgb;
	}

}
