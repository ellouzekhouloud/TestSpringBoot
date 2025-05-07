package tn.sidilec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.sidilec.Entity.FicheDeRefus;

@Repository
public interface FicheDeRefusRepository extends JpaRepository<FicheDeRefus, Long> {
	@Query("SELECT MAX(f.numeroFiche) FROM FicheDeRefus f")
	Long findMaxNumeroFiche();
}