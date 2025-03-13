package tn.sidilec.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.sidilec.Entity.Personnel;
import tn.sidilec.service.PersonnelService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")  
@RequestMapping("/api/personnels")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @GetMapping
    public List<Personnel> getAllPersonnels() {
        return personnelService.getAllPersonnels();
    }

    @GetMapping("/{id}")
    public Optional<Personnel> getPersonnelById(@PathVariable Long id) {
        return personnelService.getPersonnelById(id);
    }

    @PostMapping
    public Personnel addPersonnel(@RequestBody Personnel personnel) {
        return personnelService.addPersonnel(personnel);
    }

    @PutMapping("/{id}")
    public Personnel updatePersonnel(@PathVariable Long id, @RequestBody Personnel personnel) {
        return personnelService.updatePersonnel(id, personnel);
    }

    @DeleteMapping("/{id}")
    public void deletePersonnel(@PathVariable Long id) {
        personnelService.deletePersonnel(id);
    }
}