package com.practice.gestion_st.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Role {
    @Id
    private String role;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name="role"),
            inverseJoinColumns = @JoinColumn(name="username")
    )
    private List<User> users;
}
