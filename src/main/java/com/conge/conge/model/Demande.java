package com.conge.conge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="demandes")
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String username;
    @Column(name = "motif")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
