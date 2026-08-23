package org.example.hospital_management_system.Service;

import org.example.hospital_management_system.Entity.Patient;
import org.example.hospital_management_system.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    //READ (Get All Patients)
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    //READ (Get One Patient by ID)
    public Optional<Patient> getPatientById(String patientId) {
        return patientRepo.findById(patientId);
    }

    //CREATE & UPDATE (Save Patient)
    public Patient savePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    //DELETE (Remove Patient)
    public void deletePatient(String patientId) {
        patientRepo.deleteById(patientId);
    }

    public List<Patient> searchPatientsByName(String name) {
        return patientRepo.findByFullNameContainingIgnoreCase(name);
    }
}