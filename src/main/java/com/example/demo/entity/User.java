package com.example.demo.entity;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;


@Entity
@Audited
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}