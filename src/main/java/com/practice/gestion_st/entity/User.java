package com.practice.gestion_st.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private String username;
    private String pwd;
    private boolean active;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name="username"),
            inverseJoinColumns = @JoinColumn(name="role")
    )
    private List<Role> roles;
}
