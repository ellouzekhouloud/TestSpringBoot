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

import tn.sidilec.Entity.Fournisseur;
import tn.sidilec.service.FournisseurService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/fournisseurs")
public class FournisseurController {
	@Autowired
    private FournisseurService fournisseurService;

    @GetMapping
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurService.getAllFournisseurs();
    }

    @GetMapping("/{id}")
    public Optional<Fournisseur> getFournisseurById(@PathVariable Long id) {
        return fournisseurService.getFournisseurById(id);
    }

    @PostMapping
    public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.addFournisseur(fournisseur);
    }

    @PutMapping("/{id}")
    public Fournisseur updateFournisseur(@PathVariable Long id, @RequestBody Fournisseur fournisseur) {
        return fournisseurService.updateFournisseur(id, fournisseur);
    }

    @DeleteMapping("/{id}")
    public void deleteFournisseur(@PathVariable Long id) {
        fournisseurService.deleteFournisseur(id);
    }
}
