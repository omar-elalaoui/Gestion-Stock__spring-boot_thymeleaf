package com.practice.gestion_st.Dao;

import com.practice.gestion_st.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
