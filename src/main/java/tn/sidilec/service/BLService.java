package tn.sidilec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.sidilec.Entity.BL;
import tn.sidilec.Entity.BLProduit;
import tn.sidilec.Entity.BLRequest;
import tn.sidilec.Entity.Fournisseur;
import tn.sidilec.Entity.Produit;
import tn.sidilec.Entity.ProduitRequest;
import tn.sidilec.Repository.BLRepository;
import tn.sidilec.Repository.FournisseurRepository;
import tn.sidilec.Repository.ProduitRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BLService {

    @Autowired
    private BLRepository blRepository;
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private ProduitRepository produitRepository;

    public BL createBL(BLRequest blRequest) {
        // Récupération du fournisseur
        Fournisseur fournisseur = fournisseurRepository.findById(blRequest.getIdFournisseur())
                .orElseThrow(() -> new RuntimeException("Fournisseur introuvable"));

        // Création du bon de livraison
        BL bl = new BL();
        bl.setNumBL(blRequest.getNumBL());
        bl.setDateReception(blRequest.getDateReception());  // Ajoutez cette ligne
        bl.setNumClient(blRequest.getNumClient());  // Ajoutez cette ligne
        bl.setReference(blRequest.getReference());  // Ajoutez cette ligne
        bl.setReferenceInterne(blRequest.getReferenceInterne());  // Ajoutez cette ligne
        bl.setDescription(blRequest.getDescription());  // Ajoutez cette ligne
        bl.setFournisseur(fournisseur);

        // Ajout des produits
        List<BLProduit> produits = new ArrayList<>();
        for (ProduitRequest produitRequest : blRequest.getProduits()) {
            Produit produit = produitRepository.findById(produitRequest.getIdProduit())
                    .orElseThrow(() -> new RuntimeException("Produit introuvable"));

            BLProduit blProduit = new BLProduit();
            blProduit.setBl(bl);
            blProduit.setProduit(produit);
            blProduit.setQuantite(produitRequest.getQuantité());
            produits.add(blProduit);
        }

        bl.setProduits(produits);

        // Sauvegarde du BL
        return blRepository.save(bl);
    }
    
    public List<BL> getAllBL() {
        return blRepository.findAll();
    }
    public void deleteBL(Long id) {
        blRepository.deleteById(id);
    }


}
