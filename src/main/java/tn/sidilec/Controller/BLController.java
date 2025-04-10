package tn.sidilec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.sidilec.Entity.BL;
import tn.sidilec.Entity.BLRequest;
import tn.sidilec.service.BLService;
import java.util.List;
@RestController
@RequestMapping("/api/bl")
@CrossOrigin(origins = "http://localhost:4200")
public class BLController {

    @Autowired
    private BLService blService;

    @PostMapping("/create")
    public ResponseEntity<BL> createBL(@RequestBody BLRequest blRequestDto) {
        BL newBL = blService.createBL(blRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBL);
    }
    @GetMapping
    public List<BL> getAllBL() {
        return blService.getAllBL();
    }
    @DeleteMapping("/{idBL}")
    public void deleteBL(@PathVariable Long idBL) {
        blService.deleteBL(idBL);    
    }
}
