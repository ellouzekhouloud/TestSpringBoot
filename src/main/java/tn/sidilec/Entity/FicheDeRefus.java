package tn.sidilec.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FicheDeRefus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	public String getVerificateur() {
		return verificateur;
	}
	public void setVerificateur(String verificateur) {
		this.verificateur = verificateur;
	}
	public String getNumBL() {
		return numBL;
	}
	public void setNumBL(String numBL) {
		this.numBL = numBL;
	}
	public LocalDate getDateDeControle() {
		return dateDeControle;
	}
	public void setDateDeControle(LocalDate dateDeControle) {
		this.dateDeControle = dateDeControle;
	}
	public String getMotifRefus() {
		return motifRefus;
	}
	public void setMotifRefus(String motifRefus) {
		this.motifRefus = motifRefus;
	}
	private String fournisseur;
    private String verificateur;
    private String numBL;
    private LocalDate dateDeControle;
    private String motifRefus;
    private String raison;
	public String getRaison() {
		return raison;
	}
	public void setRaison(String raison) {
		this.raison = raison;
	}
}
