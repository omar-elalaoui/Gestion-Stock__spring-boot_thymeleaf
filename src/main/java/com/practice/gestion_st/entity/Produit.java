package com.practice.gestion_st.Entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit {
	@Id @GeneratedValue
	private long id;
	private String designation;
	private String image;
	private Long qnt_stocke;
	private double prix_unitaire;
	private double prix_vente;
	@ManyToOne
	@JoinColumn(name = "fournisseur_id")
	private Fournisseur fournisseur;
	
	@ManyToOne
	@JoinColumn(name = "categorie_id")
	private Categorie categorie;
	
}
