package com.practice.gestion_st.Service;

import java.util.List;

import com.practice.gestion_st.Entity.Client;

public interface IclientService {
	public void save(Client p);
	public void deleteById(int id);
	public Client findById(int id);
	public List<Client> findAll();
}
