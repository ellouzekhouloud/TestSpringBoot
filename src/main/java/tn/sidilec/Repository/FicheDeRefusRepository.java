package tn.sidilec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.sidilec.Entity.FicheDeRefus;

@Repository
public interface FicheDeRefusRepository extends JpaRepository<FicheDeRefus, Long> {
}