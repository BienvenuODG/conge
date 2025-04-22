
package com.conge.conge.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "demandes")
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "motif")
    private String motif;
    @Column(name = "type")
    private String type;
    @Column(name = "duree")
    private int duree;
    @Column(name = "dateDebut")
    private LocalDate dateDebut;
    @Column(name = "dateFin")
    private LocalDate dateFin;
    @Column(name = "approuve")
    private boolean approuve = false;

    // ⚠️ Supprime ce constructeur inutile pour que Jackson fonctionne
    // public Demande(...) { ... } <-- À retirer
}
