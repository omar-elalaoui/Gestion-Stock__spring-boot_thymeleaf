package com.practice.gestion_st.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.gestion_st.Entity.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {

}
