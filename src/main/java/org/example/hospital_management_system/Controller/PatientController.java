package org.example.hospital_management_system.Controller;

import jakarta.validation.Valid;
import org.example.hospital_management_system.DTO.Request.PatientRequest;
import org.example.hospital_management_system.DTO.Response.PatientResponse;
import org.example.hospital_management_system.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponse> registerPatient(@Valid @RequestBody PatientRequest request) {
        PatientResponse response = patientService.addPatient(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/multiple-appointments")
    public ResponseEntity<List<Map<String, Object>>> getPatientsWithMultipleAppointments(){
        List<Map<String, Object>> report = patientService.getPatientsWithMultipleAppointments();
        return ResponseEntity.ok(report);
    }

}