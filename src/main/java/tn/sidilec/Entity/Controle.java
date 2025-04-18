package tn.sidilec.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
public class Controle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String reference;
    private String fournisseur;
    private String verificateur;
    private String numBL;
    private String dateDeControle;
    private String raisonRefus;
    
    private Integer quantite; // Quantité mesurée
    private String quantiteStatus; // Status de la quantité : "valid" ou "invalid"

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @OneToMany(mappedBy = "controle", cascade = CascadeType.ALL)
    private List<ResultatControle> resultatsControle;
   
   
    
   
}