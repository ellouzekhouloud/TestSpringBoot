package tn.sidilec.Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.sidilec.Entity.Caracteristique;
import tn.sidilec.Entity.Fournisseur;
import tn.sidilec.Entity.Produit;
import tn.sidilec.Repository.FournisseurRepository;
import tn.sidilec.service.ProduitService;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @Autowired
    private FournisseurRepository fournisseurRepository;

    @GetMapping("/all")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> addProduit(@RequestBody Produit produit) {
        System.out.println("Produit reçu par le backend : " + produit);

        if (produit.getFournisseur() == null || produit.getFournisseur().getIdFournisseur() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur : Le fournisseur est null ou son ID est manquant !");
        }

        // Vérifier l'existence du fournisseur
        Optional<Fournisseur> fournisseurOpt = fournisseurRepository.findById(produit.getFournisseur().getIdFournisseur());

        if (!fournisseurOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erreur : Le fournisseur avec ID " + produit.getFournisseur().getIdFournisseur() + " n'existe pas.");
        }

        produit.setFournisseur(fournisseurOpt.get()); // Associer le fournisseur trouvé au produit

        // Associer les caractéristiques au produit
        for (Caracteristique caracteristique : produit.getCaracteristiques()) {
            caracteristique.setProduit(produit);
        }

        Produit savedProduit = produitService.ajouterProduit(produit);
        return ResponseEntity.ok(savedProduit);
    }

    @GetMapping("/fournisseur/{id}")
    public List<Produit> getProduitsByFournisseur(@PathVariable Long id) {
        return produitService.getProduitsByFournisseur(id);
    }

    @GetMapping("/{id}")
    public Optional<Produit> getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerProduit(@PathVariable Long id) {
        produitService.supprimerProduit(id);
    }
    
    @PostMapping("/uploadImage")
    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String uploadDir = "src/main/resources/static/images/";
            Path filePath = Paths.get(uploadDir, fileName);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            String imagePath = "/images/" + fileName;
            
            // ✅ Log pour voir la réponse
            System.out.println("Image Path: " + imagePath);
            
            // ✅ Retourner un JSON valide
            Map<String, String> response = new HashMap<>();
            response.put("imagePath", imagePath);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Échec de l'upload"));
        }
    }

    @GetMapping("/uploads/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            Path filePath = Paths.get("src/main/resources/static/images/").resolve(filename);
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG) // Adaptez selon le type d'image
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    



}
