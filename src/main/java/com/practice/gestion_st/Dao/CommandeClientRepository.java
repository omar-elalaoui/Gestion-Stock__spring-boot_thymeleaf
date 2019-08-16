package com.practice.gestion_st.Dao;


import com.practice.gestion_st.Entity.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Long> {
}
