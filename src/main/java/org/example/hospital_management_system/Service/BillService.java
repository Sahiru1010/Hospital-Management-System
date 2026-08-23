package org.example.hospital_management_system.Service;

import org.example.hospital_management_system.Entity.Bill;
import org.example.hospital_management_system.Repository.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepo billRepo;

    //Generate / Save Bill
    public Bill generateBill(Bill bill) {
        // Automatically calculate the total amount based on the 4 charge requirements
        double total = (bill.getConsultationCharges() != null ? bill.getConsultationCharges() : 0) +
                (bill.getRoomCharges() != null ? bill.getRoomCharges() : 0) +
                (bill.getLaboratoryCharges() != null ? bill.getLaboratoryCharges() : 0) +
                (bill.getMedicineCharges() != null ? bill.getMedicineCharges() : 0);

        bill.setTotalAmount(total);
        return billRepo.save(bill);
    }

    public List<Bill> getAllBills() { return billRepo.findAll(); }

    public Optional<Bill> getBillById(String id) { return billRepo.findById(id); }

    public List<Bill> getPatientBills(String patientId) { return billRepo.findByPatient_PatientIdOrderByBillDateDesc(patientId); }
}