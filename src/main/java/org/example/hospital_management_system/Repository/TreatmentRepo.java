package org.example.hospital_management_system.Repository;

import org.example.hospital_management_system.Entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TreatmentRepo extends JpaRepository<Treatment, String> {

    //Fetches the complete medical history for a patient, sorting from newest to oldest
    List<Treatment> findByPatient_PatientIdOrderByTreatmentDateDesc(String patientId);

}