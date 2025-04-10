package tn.sidilec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.sidilec.Entity.BL;

@Repository
public interface BLRepository extends JpaRepository<BL, Long> {

}
