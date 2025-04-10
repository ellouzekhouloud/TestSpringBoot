package tn.sidilec.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.sidilec.Entity.Produit;
import tn.sidilec.Repository.FamilleRepository;
import tn.sidilec.Repository.FournisseurRepository;
import tn.sidilec.Repository.ProduitRepository;
import java.util.*;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private FamilleRepository familleRepository;

  
    @GetMapping("/stats")
    public Map<String, Long> getGlobalStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalProduits", produitRepository.count());
        stats.put("totalFournisseurs", fournisseurRepository.count());
        stats.put("totalFamilles", familleRepository.count());
        return stats;
    }

   
    @GetMapping("/produits/par-famille")
    public Map<String, Long> getProduitsParFamille() {
        List<Produit> produits = produitRepository.findAll();
        return produits.stream()
                .filter(p -> p.getFamille() != null)
                .collect(Collectors.groupingBy(
                        p -> p.getFamille().getNomFamille(),
                        Collectors.counting()
                ));
    }

   
    @GetMapping("/produits/par-fournisseur")
    public Map<String, Long> getProduitsParFournisseur() {
        List<Produit> produits = produitRepository.findAll();
        return produits.stream()
                .filter(p -> p.getFournisseur() != null)
                .collect(Collectors.groupingBy(
                        p -> p.getFournisseur().getNomFournisseur(),
                        Collectors.counting()
                ));
    }

    // 🔹 Derniers produits ajoutés (optionnel, si tu as un champ dateAjout)
    // @GetMapping("/produits/recents")
    // public List<Produit> getDerniersProduits() {
    //     return produitRepository.findTop5ByOrderByDateAjoutDesc();
    // }
}
