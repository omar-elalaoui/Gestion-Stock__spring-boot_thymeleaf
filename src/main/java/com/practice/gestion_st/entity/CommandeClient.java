package com.practice.gestion_st.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class CommandeClient {
    @Id
    @GeneratedValue
    private long id;
    private String code;
    private Date dateCommande;
    private Long montant;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "commandeClient", cascade = CascadeType.ALL)
    private List<LigneCommandeClient> ligneCommandes;
}
