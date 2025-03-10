package tn.sidilec.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    private String reference;
    private String nom;
    private String description;
    private double prix;
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id", nullable = false)
    @ToString.Exclude // ✅ Exclut fournisseur du `toString()`
    @JsonProperty("fournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Caracteristique> caracteristiques = new ArrayList<>();
}