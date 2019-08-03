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
public class Fournisseur {
	@Id @GeneratedValue
	private int id;
	private String nom;
	private String telephone;
	private String adresse;
	private String email;
	
	@OneToMany(mappedBy = "fournisseur")
	private List<Produit> produits;
}
