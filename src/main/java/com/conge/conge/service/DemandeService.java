package com.conge.conge.service;

import com.conge.conge.model.Demande;
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

    // ✅ Liste toutes les demandes
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    // ✅ Trouver une demande par ID
    public Demande findById(Long id) {
        return demandeRepository.findById(id).orElse(null);
    }

    // ✅ Enregistrer une nouvelle demande
    public Demande enregistrerDemande(Demande demande) {
        System.out.println("📥 Enregistrement de la demande: " + demande);
        return demandeRepository.save(demande);
    }

    // ✅ Approuver une demande
    public Demande approuverDemande(Long id) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Demande non trouvée"));
        demande.setApprouve(true); // ✅ On approuve la demande ici
        return demandeRepository.save(demande);
    }
}
