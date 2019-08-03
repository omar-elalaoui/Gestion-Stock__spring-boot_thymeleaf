package com.practice.gestion_st.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Categorie {
	@Id @GeneratedValue
	private int id;
	private String nom;
	
	@OneToMany(mappedBy = "categorie")
	private List<Produit> produits;
}
