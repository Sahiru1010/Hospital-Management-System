package org.example.hospital_management_system.Service;

import org.example.hospital_management_system.Entity.Treatment;
import org.example.hospital_management_system.Repository.TreatmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepo treatmentRepo;

    //Record Diagnosis & Prescribe Treatment
    public Treatment saveTreatment(Treatment treatment) {
        return treatmentRepo.save(treatment);
    }

    //Maintain / View Medical History
    public List<Treatment> getPatientMedicalHistory(String patientId) {
        return treatmentRepo.findByPatient_PatientIdOrderByTreatmentDateDesc(patientId);
    }

    //Standard CRUD
    public List<Treatment> getAllTreatments() { return treatmentRepo.findAll(); }

    public Optional<Treatment> getTreatmentById(String id) { return treatmentRepo.findById(id); }
}