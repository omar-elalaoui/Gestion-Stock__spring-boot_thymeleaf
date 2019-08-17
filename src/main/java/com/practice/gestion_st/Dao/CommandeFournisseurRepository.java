package com.practice.gestion_st.Dao;

import com.practice.gestion_st.Entity.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Long> {
    @Query("from CommandeFournisseur cf where cf.dateCommande >= :d1 and cf.dateCommande <= :d2")
    public List<CommandeFournisseur> findByDateBetween(@Param("d1") Date d1, @Param("d2") Date d2);
}
