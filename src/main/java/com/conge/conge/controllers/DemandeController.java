package com.conge.conge.controllers;

import com.conge.conge.model.Demande;
import com.conge.conge.repository.DemandeRepository;
import com.conge.conge.service.DemandeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/demande")
@CrossOrigin(origins = "*")
public class DemandeController {

    private final DemandeService demandeService;

    @Autowired
    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    // ✅ Enregistrement depuis Flutter (API REST)
    @PostMapping("/enregistrer")
    public ResponseEntity<Demande> enregistrerDemande(@RequestBody Demande demande) {
        System.out.println("✅ Demande reçue depuis Flutter : " + demande);
        demande.setStatut("EN_ATTENTE"); // Initialiser le statut
        Demande savedDemande = demandeService.enregistrerDemande(demande);
        return new ResponseEntity<>(savedDemande, HttpStatus.CREATED);
    }

    // ✅ Affichage des demandes dans une vue Thymeleaf
    @GetMapping("/demande_list")
    public String listDemandes(Model model) {
        List<Demande> demandes = demandeService.getAllDemandes();
        model.addAttribute("demandes", demandes);
        return "demande_liste";
    }

    // ✅ Approbation
    @PostMapping("/approuver/{id}")
    public String approuverDemande(@PathVariable Long id) {
        demandeService.mettreAJourStatut(id, "APPROUVE");
        return "redirect:/demande/demande_list";
    }

    // ✅ Rejet
    @PostMapping("/rejeter/{id}")
    public String rejeterDemande(@PathVariable Long id) {
        demandeService.mettreAJourStatut(id, "REJETE");
        return "redirect:/demande/demande_list";
    }

    // ✅ Suppression
    @PostMapping("/supprimer/{id}")
    public String supprimerDemande(@PathVariable Long id) {
        demandeService.supprimerDemande(id);
        return "redirect:/demande/demande_list";
    }

    // mes demandes
    
}
