package com.practice.gestion_st.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String telephone;
    private String adresse;
    private String email;
    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClientList;
}
