package tn.sidilec.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Caracteristique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCaracteristique;

	private String nom;
	private String valeur;

	@ManyToOne
	@JoinColumn(name = "produit_id", nullable = false)
	@JsonIgnore
	private Produit produit;
}
