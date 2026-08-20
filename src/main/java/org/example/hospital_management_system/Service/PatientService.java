package org.example.hospital_management_system.Service;

import org.example.hospital_management_system.DTO.Request.PatientRequest;
import org.example.hospital_management_system.DTO.Response.PatientResponse;
import org.example.hospital_management_system.Entity.Patient;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import org.example.hospital_management_system.Repository.PatientRepo;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private ModelMapper modelMapper;

    public PatientResponse addPatient(PatientRequest requestDTO) {
        // 1. Map RequestDTO to Entity
        Patient patient = modelMapper.map(requestDTO, Patient.class);

        // 2. Save Entity to database
        Patient savedPatient = patientRepo.save(patient);

        // 3. Map saved Entity back to ResponseDTO
        return modelMapper.map(savedPatient, PatientResponse.class);
    }

    public List<PatientResponse> getAllPatients() {
        List<Patient> patients = patientRepo.findAll();
        return modelMapper.map(patients, new TypeToken<List<PatientResponse>>(){}.getType());
    }

    public List<Map<String, Object>> getPatientsWithMultipleAppointments(){
        return patientRepo.findPatientsWithMultipleAppointments();
    }
}