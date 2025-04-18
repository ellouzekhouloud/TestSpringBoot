package tn.sidilec.service;

import tn.sidilec.Entity.EtiquetteVerte;
import tn.sidilec.Repository.EtiquetteVerteRepository;

public class EtiquetteVerteService {
	private final EtiquetteVerteRepository etiquetteVerteRepository;

    public EtiquetteVerteService(EtiquetteVerteRepository etiquetteVerteRepository) {
        this.etiquetteVerteRepository = etiquetteVerteRepository;
    }

    public EtiquetteVerte creerEtiquette(EtiquetteVerte etiquette) {
        return etiquetteVerteRepository.save(etiquette);
    }
}
