package com.practice.gestion_st.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandeFournisseur {
    @Id
    @GeneratedValue
    private long id;
    private Date dateCommande;
    private Long montant;
    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "commandeFournisseur", cascade = CascadeType.ALL)
    private List<LigneCommandeFournisseur> ligneCommandes;
}
