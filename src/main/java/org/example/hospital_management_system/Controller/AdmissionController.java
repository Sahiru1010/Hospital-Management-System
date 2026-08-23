package org.example.hospital_management_system.Controller;

import org.example.hospital_management_system.Entity.Admission;
import org.example.hospital_management_system.Service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//REST Controller for managing Patient Admissions and Discharges.
@RestController
@RequestMapping("/api/v1/admissions")
public class AdmissionController {

    // Injects the AdmissionService to handle the business logic
    @Autowired
    private AdmissionService admissionService;

    // View all admissions of all patients (GET)
    @GetMapping
    public ResponseEntity<List<Admission>> getAll() {
        return ResponseEntity.ok(admissionService.getAllAdmissions());
    }

    //Admits a new patient and automatically allocates a room.
    @PostMapping
    public ResponseEntity<?> admitPatient(@RequestBody Admission admission) {
        try {
            return new ResponseEntity<>(admissionService.admitPatient(admission), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //Discharge based on their ID
    @PutMapping("/{id}/discharge")
    public ResponseEntity<Admission> dischargePatient(@PathVariable String id) {
        return ResponseEntity.ok(admissionService.dischargePatient(id));
    }
}