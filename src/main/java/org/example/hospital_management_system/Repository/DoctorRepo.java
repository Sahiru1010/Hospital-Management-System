package org.example.hospital_management_system.Repository;

import org.example.hospital_management_system.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, String> {
   //Finds any doctor whose name contains the letters, ignoring uppercase/lowercase
    List<Doctor> findByDoctorNameContainingIgnoreCase(String name);

} 
