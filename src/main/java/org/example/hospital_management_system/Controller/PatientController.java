package org.example.hospital_management_system.Controller;
import jakarta.validation.Valid;
import org.example.hospital_management_system.Entity.Patient;
import org.example.hospital_management_system.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    //READ (Get All Patients)
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    //READ (Get One Patient by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Returns a clean 404 if the ID doesn't exist
    }
    //SEARCH (Search by Name)
    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchPatients(@RequestParam String name) {
        return ResponseEntity.ok(patientService.searchPatientsByName(name));
    }

    //CREATE (Register New Patient)
    @PostMapping
    public ResponseEntity<Patient> registerPatient(@Valid @RequestBody Patient patient) {
        Patient savedPatient = patientService.savePatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }
    //UPDATE (Update Patient Details)
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String id, @RequestBody Patient updatedPatient) {
        return patientService.getPatientById(id).map(existingPatient -> {
            updatedPatient.setPatientId(id); // Ensure the ID doesn't change
            return ResponseEntity.ok(patientService.savePatient(updatedPatient));
        }).orElse(ResponseEntity.notFound().build());
    }

    //DELETE (Remove a Patient)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
