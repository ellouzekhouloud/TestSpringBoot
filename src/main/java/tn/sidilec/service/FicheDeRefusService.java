package tn.sidilec.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tn.sidilec.Entity.FicheDeRefus;
import tn.sidilec.Repository.FicheDeRefusRepository;

@Service
public class FicheDeRefusService {

    private final FicheDeRefusRepository ficheDeRefusRepository;

    public FicheDeRefusService(FicheDeRefusRepository ficheDeRefusRepository) {
        this.ficheDeRefusRepository = ficheDeRefusRepository;
    }

    @Transactional
    public FicheDeRefus creerFiche(FicheDeRefus fiche) {
        Long maxNumero = ficheDeRefusRepository.findMaxNumeroFiche();
        fiche.setNumeroFiche((maxNumero != null ? maxNumero : 0) + 1);
        return ficheDeRefusRepository.save(fiche);
    }
}
