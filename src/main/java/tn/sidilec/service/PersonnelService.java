package tn.sidilec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.sidilec.Entity.Personnel;
import tn.sidilec.Repository.PersonnelRepository;

@Service
public class PersonnelService {

    @Autowired
    private PersonnelRepository personnelRepository;

    public List<Personnel> getAllPersonnels() {
        return personnelRepository.findAll();
    }

    public Optional<Personnel> getPersonnelById(Long id) {
        return personnelRepository.findById(id);
    }

    public Personnel addPersonnel(Personnel personnel) {
        return personnelRepository.save(personnel);
    }

    public Personnel updatePersonnel(Long id, Personnel personnelDetails) {
        Personnel personnel = personnelRepository.findById(id).orElseThrow(() -> new RuntimeException("Personnel non trouvé"));
        personnel.setNom(personnelDetails.getNom());
        personnel.setPrenom(personnelDetails.getPrenom());
        personnel.setEmail(personnelDetails.getEmail());
        personnel.setAdresse(personnelDetails.getAdresse());
        personnel.setTelephone(personnelDetails.getTelephone());
        personnel.setPoste(personnelDetails.getPoste());
        return personnelRepository.save(personnel);
    }

    public void deletePersonnel(Long id) {
        personnelRepository.deleteById(id);
    }
}