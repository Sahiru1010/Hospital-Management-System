package org.example.hospital_management_system.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "TREATMENT")
@Data
public class Treatment {

    @Id
    @Column(name = "Treatment_ID", length = 20)
    private String treatmentId;

    @Column(name = "Diagnosis", nullable = false, length = 255)
    private String diagnosis;

    @Column(name = "Prescription", columnDefinition = "TEXT")
    private String prescription;

    @Column(name = "Treatment_Notes", columnDefinition = "TEXT")
    private String treatmentNotes;

    @Column(name = "Treatment_Date", nullable = false)
    private LocalDate treatmentDate;

    // Links the treatment to a specific patient to maintain their Medical History
    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    // Identifies which doctor recorded the diagnosis
    @ManyToOne
    @JoinColumn(name = "Doctor_ID", nullable = false)
    private Doctor doctor;
}