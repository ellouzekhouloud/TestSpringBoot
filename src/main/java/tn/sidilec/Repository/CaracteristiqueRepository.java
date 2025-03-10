package tn.sidilec.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sidilec.Entity.Caracteristique;

public interface CaracteristiqueRepository extends JpaRepository<Caracteristique, Long> {
    List<Caracteristique> findByProduit_IdProduit(Long produitId);
}