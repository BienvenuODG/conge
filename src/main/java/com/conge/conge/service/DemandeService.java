package com.conge.conge.service;

import com.conge.conge.model.Demande;
import com.conge.conge.model.User;
import com.conge.conge.repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeService {

    private final DemandeRepository demandeRepository;

    @Autowired
    public DemandeService(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    // Liste des demandes
    public List<Demande> findAll() { return demandeRepository.findAll(); }

    // Enregistrer une nouvelle demande
    public Demande enregistrerDemande(Demande demande) {
        // Log pour s'assurer que la demande est bien reçue
        System.out.println("Enregistrement de la demande: " + demande);
        return demandeRepository.save(demande);
    }

    // Approuver une demande
    public Demande approuverDemande(Long id) {
        Demande demande = demandeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Demande invalide"));
        demande.setType("Approuvé");
        return demandeRepository.save(demande);
    }
}
