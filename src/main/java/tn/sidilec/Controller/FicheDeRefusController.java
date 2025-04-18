package tn.sidilec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.sidilec.Entity.FicheDeRefus;
import tn.sidilec.Repository.FicheDeRefusRepository;
import java.util.List;
@RestController
@RequestMapping("/api/fichesRefus")
@CrossOrigin(origins = "*")  
public class FicheDeRefusController {
public FicheDeRefusController() {
	// TODO Auto-generated constructor stub
}
    @Autowired
    private FicheDeRefusRepository ficheDeRefusRepository;

    @PostMapping
    public FicheDeRefus saveFicheDeRefus(@RequestBody FicheDeRefus ficheDeRefus) {
        return ficheDeRefusRepository.save(ficheDeRefus);
    }

    @GetMapping
    public List<FicheDeRefus> getAllFichesDeRefus() {
        return ficheDeRefusRepository.findAll();
    }

}
