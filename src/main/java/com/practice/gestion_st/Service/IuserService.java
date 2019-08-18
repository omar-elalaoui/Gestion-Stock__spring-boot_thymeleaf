package com.practice.gestion_st.Service;

import com.practice.gestion_st.Entity.User;

import java.util.List;


public interface IuserService {
    public void save(User user);
    public void deleteById(String username);
    public User findById(String username);
    public List<User> findAll();
}
