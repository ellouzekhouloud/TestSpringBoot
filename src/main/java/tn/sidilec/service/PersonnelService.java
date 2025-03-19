package tn.sidilec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;

import tn.sidilec.Entity.Personnel;
import tn.sidilec.Repository.PersonnelRepository;

@Service
public class PersonnelService {

	@Autowired
	private PersonnelRepository personnelRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<Personnel> getAllPersonnels() {
		return personnelRepository.findAll();
	}

	public Optional<Personnel> getPersonnelById(Long id) {
		return personnelRepository.findById(id);
	}

	// Obtenir un personnel par matricule
	public Optional<Personnel> getPersonnelByMatricule(String matricule) {
		return personnelRepository.findByMatricule(matricule);
	}

	// Ajouter un nouveau personnel
	public Personnel addPersonnel(Personnel personnel) {
		// Vérifier si le matricule est unique
		if (personnelRepository.findByMatricule(personnel.getMatricule()).isPresent()) {
			throw new RuntimeException("Matricule déjà utilisé !");
		}

		// Hacher le mot de passe avant de le sauvegarder
		String hashedPassword = passwordEncoder.encode(personnel.getMotDePasse());
		personnel.setMotDePasse(hashedPassword);

		return personnelRepository.save(personnel);
	}

	// Mettre à jour un personnel existant
	public Personnel updatePersonnel(Long id, Personnel personnelDetails) {
		Personnel personnel = personnelRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Personnel non trouvé"));

		personnel.setNom(personnelDetails.getNom());
		personnel.setPrenom(personnelDetails.getPrenom());
		personnel.setEmail(personnelDetails.getEmail());
		personnel.setMatricule(personnelDetails.getMatricule());
		personnel.setQualifications(personnelDetails.getQualifications());

		// Mettre à jour le mot de passe s'il est fourni
		if (personnelDetails.getMotDePasse() != null && !personnelDetails.getMotDePasse().isEmpty()) {
			String hashedPassword = passwordEncoder.encode(personnelDetails.getMotDePasse());
			personnel.setMotDePasse(hashedPassword);
		}

		return personnelRepository.save(personnel);
	}

	// Supprimer un personnel
	public void deletePersonnel(Long id) {
		if (!personnelRepository.existsById(id)) {
			throw new RuntimeException("Personnel non trouvé");
		}
		personnelRepository.deleteById(id);
	}
}