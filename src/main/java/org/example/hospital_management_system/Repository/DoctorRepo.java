package org.example.hospital_management_system.Repository;

import org.example.hospital_management_system.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, String> {


    @Query(value = "SELECT d.Doctor_ID, d.Doctor_Name, d.Specialization, dept.Department_Name " +
            "FROM DOCTOR d JOIN DEPARTMENT dept ON d.Department_ID = dept.Department_ID " +
            "ORDER BY dept.Department_Name",
    nativeQuery = true)
    List<Map<String, Object>> findDoctorsByDepartment();

    @Query(value = "SELECT d.Doctor_ID, d.Doctor_Name, d.Specialization, COUNT(a.Appointment_ID) AS Total_Appointments " +
            "FROM DOCTOR d JOIN APPOINTMENT a ON d.Doctor_ID = a.Doctor_ID " +
            "GROUP BY d.Doctor_ID, d.Doctor_Name, d.Specialization " +
            "ORDER BY Total_Appointments DESC LIMIT 1",
    nativeQuery = true)
    List<Map<String, Object>> findMostFrequentlyVisitedDoctor();

} 
