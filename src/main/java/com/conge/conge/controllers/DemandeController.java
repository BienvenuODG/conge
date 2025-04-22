package com.conge.conge.controllers;

import com.conge.conge.model.Demande;
import com.conge.conge.repository.DemandeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demande")
@CrossOrigin(origins = "*") // autoriser les requêtes CORS depuis n'importe quelle origine (Flutter, etc.)
public class DemandeController {

    private final DemandeRepository demandeRepository;

    @Autowired
    public DemandeController(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    @PostMapping("/enregistrer")
    public ResponseEntity<Demande> enregistrerDemande(@RequestBody Demande demande) {
        System.out.println("✅ Demande reçue depuis Flutter : " + demande);

        demande.setApprouve(false); // sécurité : ne jamais permettre au client de définir cet attribut

        Demande savedDemande = demandeRepository.save(demande);
        return new ResponseEntity<>(savedDemande, HttpStatus.CREATED);
    }

    @GetMapping("/liste")
    public String afficherDemandes(Model model) {
        // Récupérer toutes les demandes depuis la base de données via le service
        model.addAttribute("demande", demandeService.getAllDemandes());  // Changer "findAll()" par "getAllDemandes()"
        return "demande_liste";  // Nom de la vue Thymeleaf
    }

    @PutMapping("/demande/approuver/{id}")
    public String approuverDemande(@PathVariable Long id) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée"));
        demande.setApprouve(true);
        demandeRepository.save(demande);
        return "redirect:/demande/liste";  // Rediriger vers la liste après l'approbation
    }
}
