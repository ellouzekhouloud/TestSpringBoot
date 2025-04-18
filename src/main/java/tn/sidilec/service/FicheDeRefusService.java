package tn.sidilec.service;

import org.springframework.stereotype.Service;

import tn.sidilec.Entity.FicheDeRefus;
import tn.sidilec.Repository.FicheDeRefusRepository;

@Service
public class FicheDeRefusService {

    private final FicheDeRefusRepository ficheDeRefusRepository;

    public FicheDeRefusService(FicheDeRefusRepository ficheDeRefusRepository) {
        this.ficheDeRefusRepository = ficheDeRefusRepository;
    }

    public FicheDeRefus creerFiche(FicheDeRefus fiche) {
        
        return ficheDeRefusRepository.save(fiche);
    }
}
