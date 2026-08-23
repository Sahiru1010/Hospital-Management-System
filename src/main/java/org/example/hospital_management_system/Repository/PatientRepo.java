package org.example.hospital_management_system.Repository;


import org.example.hospital_management_system.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface PatientRepo extends JpaRepository<Patient, String> {

    //Finds any patient whose name contains the letters, ignoring uppercase/lowercase
    List<Patient> findByFullNameContainingIgnoreCase(String name);
}
