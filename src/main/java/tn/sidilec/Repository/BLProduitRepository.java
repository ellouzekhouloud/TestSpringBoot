package tn.sidilec.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.sidilec.Entity.BLProduit;
import java.util.List;

@Repository
public interface BLProduitRepository extends JpaRepository<BLProduit, Long> {
	 //Optional<BLProduit> findByBlNumBLAndProduitReference(String numBL, String reference);
	Optional<BLProduit> findFirstByProduitReferenceOrderByBlDateReceptionDesc(String referenceProduit);

	@Query("SELECT bp FROM BLProduit bp WHERE bp.produit.id = :produitId AND bp.status = :status")
	List<BLProduit> findByProduitIdAndStatus(@Param("produitId") Long produitId, @Param("status") String status);

	@Query("SELECT bp FROM BLProduit bp WHERE bp.bl.id = :blId")
	List<BLProduit> findByBlId(@Param("blId") Long blId);
	
	List<BLProduit> findByBlIdAndIsControleTrue(Long blId);

}
