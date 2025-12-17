package com.example.bankcards.entity;

import io.jsonwebtoken.Jwts;
import jakarta.persistence.*;
import com.example.bankcards.entity.Role;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public void setUsername(String username) { this.username = username; }
    public String getUsername() { return username; }

    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password; }

    public void setRole(Role role) { this.role = role; }
    public Role getRole() { return role; }


}
