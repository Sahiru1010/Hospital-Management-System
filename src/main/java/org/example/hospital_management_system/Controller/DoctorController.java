package org.example.hospital_management_system.Controller;

import jakarta.validation.Valid;
import org.example.hospital_management_system.Entity.Doctor;
import org.example.hospital_management_system.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //READ (Get All Doctors)
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    //READ (Get One Doctor by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable String id) {
        return doctorService.getDoctorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Returns 404 if the doctor doesn't exist
    }

    //CREATE (Add New Doctor)
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    //UPDATE (Update  Details)
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable String id, @RequestBody Doctor updatedDoctor) {
        return doctorService.getDoctorById(id).map(existingDoctor -> {
            updatedDoctor.setDoctorId(id); // Ensure the ID doesn't change
            return ResponseEntity.ok(doctorService.saveDoctor(updatedDoctor));
        }).orElse(ResponseEntity.notFound().build());
    }

    //SEARCH (Search by Name)
    @GetMapping("/search")
    public ResponseEntity<List<Doctor>> searchDoctors(@RequestParam String name) {
        // Example implementation assuming you added the repo method
        return ResponseEntity.ok(doctorService.searchDoctorByName(name));
    }
    //DELETE (Delete Doctor by ID)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable String id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}