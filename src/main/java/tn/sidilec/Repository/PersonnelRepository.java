package tn.sidilec.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sidilec.Entity.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
	Optional<Personnel> findByMatricule(String matricule);
	Optional<Personnel> findByEmail(String email);
}
