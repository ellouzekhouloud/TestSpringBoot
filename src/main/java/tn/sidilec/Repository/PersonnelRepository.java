package tn.sidilec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sidilec.Entity.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
    
}
