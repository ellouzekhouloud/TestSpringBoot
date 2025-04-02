package tn.sidilec.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sidilec.Entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByFournisseur_IdFournisseur(Long fournisseurId);
    
    Optional<Produit> findByReference(String reference);
    
    
}