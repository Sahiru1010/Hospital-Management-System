package org.example.hospital_management_system.Controller;

import org.example.hospital_management_system.Entity.Treatment;
import org.example.hospital_management_system.Service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/treatments")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    //Record Diagnosis and Prescribe (POST)
    @PostMapping
    public ResponseEntity<Treatment> recordTreatment(@RequestBody Treatment treatment) {
        return new ResponseEntity<>(treatmentService.saveTreatment(treatment), HttpStatus.CREATED);
    }

    //View Medical History for a Specific Patient (GET)
    @GetMapping("/history/{patientId}")
    public ResponseEntity<List<Treatment>> getMedicalHistory(@PathVariable String patientId) {
        return ResponseEntity.ok(treatmentService.getPatientMedicalHistory(patientId));
    }

    //Update Existing Treatment Details (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Treatment> updateTreatment(@PathVariable String id, @RequestBody Treatment treatment) {
        return treatmentService.getTreatmentById(id).map(existing -> {
            treatment.setTreatmentId(id);
            return ResponseEntity.ok(treatmentService.saveTreatment(treatment));
        }).orElse(ResponseEntity.notFound().build());
    }
}