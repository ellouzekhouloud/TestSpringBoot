package tn.sidilec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.sidilec.Entity.EtiquetteVerte;

@Repository
public interface EtiquetteVerteRepository extends JpaRepository<EtiquetteVerte, Long> {
}


