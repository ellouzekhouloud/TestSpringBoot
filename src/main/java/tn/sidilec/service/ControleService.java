package tn.sidilec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tn.sidilec.Entity.Controle;
import tn.sidilec.Entity.PlanDeControle;
import tn.sidilec.Entity.Produit;
import tn.sidilec.Entity.ResultatControle;
import tn.sidilec.Repository.ControleRepository;
import tn.sidilec.Repository.PlanDeControleRepository;
import tn.sidilec.Repository.ProduitRepository;


import java.util.List;

@Service
public class ControleService {
    @Autowired
    private ControleRepository controleRepository;
    
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private PlanDeControleRepository planDeControleRepository;

    @Transactional
    public void enregistrerControle(Controle controle) {
        // Vérifier que le produit existe
        Produit produit = produitRepository.findById(controle.getProduit().getIdProduit())
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));
        controle.setProduit(produit);

        // Lier les résultats de contrôle aux plans de contrôle
        for (ResultatControle resultat : controle.getResultatsControle()) {
            PlanDeControle plan = planDeControleRepository.findById(resultat.getPlanDeControle().getId())
                    .orElseThrow(() -> new RuntimeException("Plan de contrôle introuvable"));
            resultat.setPlanDeControle(plan);
            resultat.setControle(controle);
        }

        // Sauvegarde du contrôle avec les résultats
        controleRepository.save(controle);
    }

    public List<Controle> getControles() {
        return controleRepository.findAll();
    }

   
}