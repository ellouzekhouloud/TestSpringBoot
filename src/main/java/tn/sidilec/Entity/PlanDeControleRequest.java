package tn.sidilec.Entity;

import java.util.List;

public class PlanDeControleRequest {
	private Long idProduit;
    private List<PlanDeControle> lignes;

    
    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public List<PlanDeControle> getLignes() {
        return lignes;
    }

    public void setLignes(List<PlanDeControle> lignes) {
        this.lignes = lignes;
    }
}
