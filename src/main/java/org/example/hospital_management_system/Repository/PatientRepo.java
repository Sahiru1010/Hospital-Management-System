package org.example.hospital_management_system.Repository;


import org.example.hospital_management_system.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface PatientRepo extends JpaRepository<Patient, String> {

    // Task 07 - Query 8: Display patients with multiple appointments[cite: 5]
    @Query(value = "SELECT p.Patient_ID, p.Full_Name, COUNT(a.Appointment_ID) AS Appointment_Count " +
            "FROM PATIENT p JOIN APPOINTMENT a ON p.Patient_ID = a.Patient_ID " +
            "GROUP BY p.Patient_ID, p.Full_Name HAVING COUNT(a.Appointment_ID) > 1",
            nativeQuery = true)
    List<Map<String, Object>> findPatientsWithMultipleAppointments();

    // Task 07 - Query 4: Find patients admitted to ICU rooms[cite: 5]
    @Query(value = "SELECT p.Patient_ID, p.Full_Name, p.Contact_Details, r.Bed_Number, adm.Admission_Date " +
            "FROM ADMISSION adm JOIN PATIENT p ON adm.Patient_ID = p.Patient_ID " +
            "JOIN ROOM r ON adm.Room_ID = r.Room_ID " +
            "JOIN ROOM_CATEGORY rc ON r.Category_ID = rc.Category_ID " +
            "WHERE rc.Category_Name = 'ICU' AND adm.Admission_Status = 'Admitted'",
            nativeQuery = true)
    List<Map<String, Object>> findPatientsInICU();
}
