package tn.sidilec.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class PlanDeControle {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String caracteristique;
    private String donneeTechnique;
    private String tolerance;
    private String frequenceEtTailleDePrelevement;
    private String moyenDeControle;
    private String methodeDeControle;

    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit;
}
