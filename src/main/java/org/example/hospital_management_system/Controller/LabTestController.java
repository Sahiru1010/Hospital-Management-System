package org.example.hospital_management_system.Controller;

import org.example.hospital_management_system.Entity.LabTest;
import org.example.hospital_management_system.Service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/lab-tests")
public class LabTestController {

    @Autowired
    private LabTestService labTestService;

    //Add Laboratory Tests
    @PostMapping
    public ResponseEntity<LabTest> addTest(@RequestBody LabTest labTest) {
        return new ResponseEntity<>(labTestService.saveLabTest(labTest), HttpStatus.CREATED);
    }

    //Update Laboratory Results
    @PutMapping("/{id}")
    public ResponseEntity<LabTest> updateResult(@PathVariable String id, @RequestBody LabTest labTest) {
        return labTestService.getLabTestById(id).map(existing -> {
            labTest.setLabTestId(id); // Ensure the ID stays the same
            return ResponseEntity.ok(labTestService.saveLabTest(labTest));
        }).orElse(ResponseEntity.notFound().build());
    }

    //View Laboratory History for a Specific Patient
    @GetMapping("/history/{patientId}")
    public ResponseEntity<List<LabTest>> viewHistory(@PathVariable String patientId) {
        return ResponseEntity.ok(labTestService.getLaboratoryHistory(patientId));
    }
}