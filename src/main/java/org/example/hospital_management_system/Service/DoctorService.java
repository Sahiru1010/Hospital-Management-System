package org.example.hospital_management_system.Service;

import org.example.hospital_management_system.Entity.Doctor;
import org.example.hospital_management_system.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    //READ (Get All Doctors)
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    //READ (Get One Doctor by ID)
    public Optional<Doctor> getDoctorById(String doctorId) {
        return doctorRepo.findById(doctorId);
    }

    //CREATE & UPDATE (Save Doctor)
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    //DELETE (Remove Doctor)
    public void deleteDoctor(String doctorId) {
        doctorRepo.deleteById(doctorId);
    }

    public Doctor updateDoctor(Doctor doctor){
        return doctorRepo.save(doctor);
    }
    public List<Doctor> searchDoctorByName(String name){
        return doctorRepo.findByDoctorNameContainingIgnoreCase(name);
    }
}