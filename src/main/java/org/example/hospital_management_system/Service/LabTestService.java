package org.example.hospital_management_system.Service;

import org.example.hospital_management_system.Entity.LabTest;
import org.example.hospital_management_system.Repository.LabTestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LabTestService {

    @Autowired
    private LabTestRepo labTestRepo;

    //Add or Update Laboratory Test
    public LabTest saveLabTest(LabTest labTest) {
        return labTestRepo.save(labTest);
    }

    //View Laboratory History
    public List<LabTest> getLaboratoryHistory(String patientId) {
        return labTestRepo.findByPatient_PatientIdOrderByTestDateDesc(patientId);
    }

    public Optional<LabTest> getLabTestById(String id) {
        return labTestRepo.findById(id);
    }
}