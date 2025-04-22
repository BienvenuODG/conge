
package com.conge.conge.repository;

import com.conge.conge.model.Demande;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
    
    // Des méthodes supplémentaires peuvent être ajoutées ici si nécessaire
    //Optional<Demande> findByUserUsername(String username);  // Modification ici
}
