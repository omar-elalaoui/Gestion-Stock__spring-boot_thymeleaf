package com.practice.gestion_st.Service.Imp;

import com.practice.gestion_st.Dao.UserRepository;
import com.practice.gestion_st.Entity.User;
import com.practice.gestion_st.Service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IuserService {
    @Autowired
    UserRepository userRepository;
    
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
    
    @Override
    public void deleteById(String username) {
        userRepository.deleteById(username);
    }
    
   
    
    @Override
    public User findById(String username) {
        if(!userRepository.findById(username).isPresent()) {
            throw new RuntimeException("user not found "+username);
        }
        return userRepository.findById(username).get();
        
    }
    
    @Override
    public List<User> findAll() {return userRepository.findAll(); }
}
