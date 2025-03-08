package tn.sidilec.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Fournisseur {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFournisseur;

    private String nomFournisseur;
    private String email;
    private String adresse;
    private String telephone;
    
    

}
