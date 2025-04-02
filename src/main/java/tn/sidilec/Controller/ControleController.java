package tn.sidilec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.sidilec.Entity.Controle;
import tn.sidilec.service.ControleService;

import java.util.List;

@RestController
@RequestMapping("/api/controles")
@CrossOrigin("*")
public class ControleController {
    @Autowired
    private ControleService controleService;

    @PostMapping("/enregistrer")
    public ResponseEntity<String> enregistrerControle(@RequestBody Controle controle) {
        try {
            controleService.enregistrerControle(controle);
            return ResponseEntity.ok("Contrôle enregistré avec succès !");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur lors de l'enregistrement du contrôle: " + e.getMessage());
        }
    }
    
    @GetMapping("/tous")
    public List<Controle> getTousLesControles() {
        return controleService.getControles();
    }

    
}