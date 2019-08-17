package com.practice.gestion_st.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class LigneCommandeFournisseur {
    @Id
    @GeneratedValue
    private long id;
    private int quantite;
    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "commande_fournisseur_id")
    private CommandeFournisseur commandeFournisseur;
}
