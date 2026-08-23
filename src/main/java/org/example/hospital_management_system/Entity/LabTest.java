package org.example.hospital_management_system.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "LAB_TEST")
@Data
public class LabTest {

    @Id
    @Column(name = "Lab_Test_ID", length = 20)
    private String labTestId;

    @Column(name = "Test_Name", nullable = false, length = 150)
    private String testName;

    @Column(name = "Test_Date", nullable = false)
    private LocalDate testDate;

    //This will hold the actual results ("Hemoglobin: 13.5 g/dL")
    @Column(name = "Test_Result", columnDefinition = "TEXT")
    private String testResult;

    @Column(name = "Technician_Name", length = 100)
    private String technicianName;

    //"Pending", "Processing", "Completed"
    @Column(name = "Test_Status", length = 50)
    private String testStatus = "Pending";

    //Required to maintain a patient's laboratory history
    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;
}