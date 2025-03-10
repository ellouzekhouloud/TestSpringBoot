package tn.sidilec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.sidilec.Entity.Caracteristique;
import tn.sidilec.Repository.CaracteristiqueRepository;

@Service
public class CaracteristiqueService {
    @Autowired
    private CaracteristiqueRepository caracteristiqueRepository;

    public List<Caracteristique> getCaracteristiquesByProduit(Long produitId) {
        return caracteristiqueRepository.findByProduit_IdProduit(produitId);
    }

    public Caracteristique ajouterCaracteristique(Caracteristique caracteristique) {
        return caracteristiqueRepository.save(caracteristique);
    }

    public void supprimerCaracteristique(Long id) {
        caracteristiqueRepository.deleteById(id);
    }
}