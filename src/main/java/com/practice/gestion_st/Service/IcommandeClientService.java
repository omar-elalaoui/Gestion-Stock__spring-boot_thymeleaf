package com.practice.gestion_st.Service;

import com.practice.gestion_st.Entity.CommandeClient;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IcommandeClientService {
    public void save(CommandeClient commandeClient);
    public void deleteById(Long id);
    public CommandeClient findById(Long id);
    public List<CommandeClient> findAll();
    public CommandeClient cleanCommande(CommandeClient cf);
    public long getCmdMontant(CommandeClient cf);
    public long getCmdsMontant(List<CommandeClient> cmdsF);
    public List<CommandeClient> findByDateBetween(Date d1, Date d2);
}
