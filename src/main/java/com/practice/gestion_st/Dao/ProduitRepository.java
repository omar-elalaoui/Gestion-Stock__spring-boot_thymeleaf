package com.practice.gestion_st.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.practice.gestion_st.Entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer>{
		
}
