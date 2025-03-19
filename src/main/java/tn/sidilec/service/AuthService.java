package tn.sidilec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.sidilec.Entity.Personnel;
import tn.sidilec.Repository.PersonnelRepository;

@Service
public class AuthService {
	 private final PersonnelRepository personnelRepository;
	 @Autowired
		private PasswordEncoder passwordEncoder;

	    public AuthService(PersonnelRepository personnelRepository) {
	        this.personnelRepository = personnelRepository;
	    }

	    public boolean authenticate(String email, String motDePasse) {
	        Optional<Personnel> personnel = personnelRepository.findByEmail(email);

	        if (personnel.isEmpty()) {
	            System.out.println("Aucun utilisateur trouvé avec cet email !");
	            return false;
	        }

	        System.out.println("Utilisateur trouvé : " + personnel.get().getEmail());
	        System.out.println("Mot de passe en base : " + personnel.get().getMotDePasse());
	        System.out.println("Mot de passe entré : " + motDePasse);


	        // Comparaison du mot de passe haché
	        return passwordEncoder.matches(motDePasse, personnel.get().getMotDePasse());
	    }
}
