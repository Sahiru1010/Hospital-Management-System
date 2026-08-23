package org.example.hospital_management_system.Controller;

import org.example.hospital_management_system.Entity.Bill;
import org.example.hospital_management_system.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    @Autowired
    private BillService billService;

    //Generate a New Bill
    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        return new ResponseEntity<>(billService.generateBill(bill), HttpStatus.CREATED);
    }

    //View Patient Billing History
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Bill>> getPatientBills(@PathVariable String patientId) {
        return ResponseEntity.ok(billService.getPatientBills(patientId));
    }

    //Update Payment Status
    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable String id, @RequestBody Bill bill) {
        return billService.getBillById(id).map(existingBill -> {
            bill.setBillId(id);
            return ResponseEntity.ok(billService.generateBill(bill)); // Re-calculates total just in case
        }).orElse(ResponseEntity.notFound().build());
    }
}