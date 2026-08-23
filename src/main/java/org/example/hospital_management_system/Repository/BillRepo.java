package org.example.hospital_management_system.Repository;

import org.example.hospital_management_system.Entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BillRepo extends JpaRepository<Bill, String> {

    // Allows the hospital to look up a patient's billing history
    List<Bill> findByPatient_PatientIdOrderByBillDateDesc(String patientId);
}