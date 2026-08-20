package org.example.hospital_management_system.Service;


import org.example.hospital_management_system.DTO.Request.DoctorRequestDTO;
import org.example.hospital_management_system.DTO.Response.DoctorResponseDTO;
import org.example.hospital_management_system.Entity.Doctor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.hospital_management_system.Repository.DoctorRepo;

import java.util.List;

@Service
@Transactional

public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private ModelMapper modelMapper;

    public DoctorResponseDTO addDoctor(DoctorRequestDTO requestDTO){
        Doctor doctor = modelMapper.map(requestDTO, Doctor.class);
        Doctor savedDoctor = doctorRepo.save(doctor);
        return modelMapper.map(savedDoctor, DoctorResponseDTO.class);
    }
    public List<DoctorResponseDTO> getAllDoctors(){
        List<Doctor> doctors = doctorRepo.findAll();
        return modelMapper.map(doctors, new TypeToken<List<DoctorResponseDTO>>(){}.getType());
    }
}
