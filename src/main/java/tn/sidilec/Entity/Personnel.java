package tn.sidilec.Entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    @Column(unique = true, nullable = false)
    private String matricule;
    private String qualifications;
    
    @Column(unique = true, nullable = false)
    private String email;
  
    @Column(nullable = false)
    private String motDePasse;
    

    // Constructeur par défaut
    public Personnel() {
    }

    // Constructeur avec paramètres
    public Personnel(String nom, String prenom, String matricule, String qualifications, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.qualifications = qualifications;
        this.email = email;
        this.motDePasse = new BCryptPasswordEncoder().encode(motDePasse); // Encodage du mot de passe
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

}
