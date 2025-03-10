package tn.sidilec.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.sidilec.Entity.Caracteristique;
import tn.sidilec.service.CaracteristiqueService;

@RestController
@RequestMapping("/api/caracteristiques")
@CrossOrigin(origins = "http://localhost:4200")
public class CaracteristiqueController {
    @Autowired
    private CaracteristiqueService caracteristiqueService;

    @GetMapping("/produit/{id}")
    public List<Caracteristique> getCaracteristiquesByProduit(@PathVariable Long id) {
        return caracteristiqueService.getCaracteristiquesByProduit(id);
    }

    @PostMapping("/add")
    public Caracteristique ajouterCaracteristique(@RequestBody Caracteristique caracteristique) {
        return caracteristiqueService.ajouterCaracteristique(caracteristique);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerCaracteristique(@PathVariable Long id) {
        caracteristiqueService.supprimerCaracteristique(id);
    }
}