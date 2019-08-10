package com.practice.gestion_st.Service.Imp;

import java.util.List;

import com.practice.gestion_st.Dao.ClientRepository;
import com.practice.gestion_st.Entity.Client;
import com.practice.gestion_st.Service.IclientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IclientService {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public void save(Client p) {
		clientRepository.save(p);
	}

	@Override
	public void deleteById(int id) {
		clientRepository.deleteById(id);

	}

	@Override
	public Client findById(int id) {
		if(!clientRepository.findById(id).isPresent()) {
			throw new RuntimeException("produit not found "+id);
		}
		return clientRepository.findById(id).get();
	}

}
