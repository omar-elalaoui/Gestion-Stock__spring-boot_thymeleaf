package com.practice.gestion_st.Service.Imp;

import com.practice.gestion_st.Dao.CommandeClientRepository;
import com.practice.gestion_st.Entity.CommandeClient;
import com.practice.gestion_st.Service.IcommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeClientService implements IcommandeClientService {
    @Autowired
    CommandeClientRepository commandeClientRepository;

    @Override
    public void save(CommandeClient commandeClient) {
        commandeClientRepository.save(commandeClient);
    }

    @Override
    public void deleteById(Long id) {
        commandeClientRepository.deleteById(id);
    }

    @Override
    public CommandeClient findById(Long id) {
        if(!commandeClientRepository.findById(id).isPresent()) {
            throw new RuntimeException("commande not found "+id);
        }
        return commandeClientRepository.findById(id).get();
    }

    @Override
    public List<CommandeClient> findAll() {
        return commandeClientRepository.findAll();
    }
}
