package pe.com.easyjobs.accountsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.com.easyjobs.accountsapi.entity.Technician;
import pe.com.easyjobs.accountsapi.service.TechnicianService;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/technicians")
public class TechnicianController {
    @Autowired
    private TechnicianService technicianService;

    @PostMapping(value = "/createTechnician")
    public ResponseEntity<Technician> createTechnician(@RequestBody Technician technician){
        Technician technicianCreated = technicianService.createTechnician(technician);
        return ResponseEntity.ok(technicianCreated);
    }

    @GetMapping(value = "/getTechnician/{id}")
    public ResponseEntity<Technician> getTechnician(@PathVariable("id") Long id){
        Technician technician = technicianService.getByTechnicianId(id);
        return ResponseEntity.ok(technician);
    }

    @GetMapping(value = "/getTechnicians")
    public ResponseEntity<Iterable<Technician>> getTechnicians(){
        Iterable<Technician> technicians = technicianService.getAllTechnicians();
        return ResponseEntity.ok(technicians);
    }

    @PutMapping(value = "/updateTechnician/{id}")
    public ResponseEntity<Technician> updateTechnician(@PathVariable("id") Long id, @RequestBody Technician technician){
        Technician technicianUpdated = technicianService.updateTechnician(id, technician);
        return ResponseEntity.ok(technicianUpdated);
    }

    @PutMapping(value = "/deleteTechnician/{id}")
    public ResponseEntity<Technician> deleteTechnician(@PathVariable("id") Long id){
        Technician technicianDeleted = technicianService.deleteTechnician(id);
        return ResponseEntity.ok(technicianDeleted);
    }
}

