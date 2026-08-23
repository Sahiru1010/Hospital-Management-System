package org.example.hospital_management_system.Repository;

import org.example.hospital_management_system.Entity.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface LabTestRepo extends JpaRepository<LabTest, String> {
    //Custom query to "View laboratory history" for a specific patient
    List<LabTest> findByPatient_PatientIdOrderByTestDateDesc(String patientId);

}
