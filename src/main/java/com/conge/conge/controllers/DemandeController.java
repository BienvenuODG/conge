package com.conge.conge.controllers;

import com.conge.conge.model.Demande;
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

    // ✅ Pour l'enregistrement depuis Flutter
    @PostMapping("/enregistrer")
    public ResponseEntity<Demande> enregistrerDemande(@RequestBody Demande demande) {
        System.out.println("✅ Demande reçue depuis Flutter : " + demande);
        demande.setApprouve(false); // Sécurité
        Demande savedDemande = demandeService.enregistrerDemande(demande);
        return new ResponseEntity<>(savedDemande, HttpStatus.CREATED);
    }

    // ✅ Pour afficher toutes les demandes dans une vue web (Thymeleaf)
    @GetMapping("/demande_list")
    public String listDemandes(Model model) {
        List<Demande> demandes = demandeService.getAllDemandes();
        model.addAttribute("demandes", demandes); // à appeler "demandes" dans la vue
        return "demande_liste"; // nom du fichier HTML (demande_liste.html)
    }

    // ✅ Pour approuver une demande via la web app
    @PutMapping("/approuver/{id}")
    public String approuverDemande(@PathVariable Long id) {
        demandeService.approuverDemande(id);
        return "redirect:/demande/demande_list";
    }
}
