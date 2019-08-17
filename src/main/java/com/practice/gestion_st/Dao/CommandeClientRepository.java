package com.practice.gestion_st.Dao;


import com.practice.gestion_st.Entity.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Long> {
    @Query("from CommandeClient cc where cc.dateCommande >= :d1 and cc.dateCommande <= :d2")
    public List<CommandeClient> findByDateBetween(@Param("d1") Date d1, @Param("d2") Date d2);
}
