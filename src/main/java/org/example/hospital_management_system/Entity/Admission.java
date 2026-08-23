package org.example.hospital_management_system.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "ADMISSION")
@Data

public class Admission {
    @Id
    @Column(name = "Admission_ID", length = 20)
    private String admissionId;

    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "Room_ID", nullable = false)
    private Room room;

    @Column(name = "Admission_Date", nullable = false)
    private LocalDate admissionDate;

    @Column(name = "Discharge_Date")
    private LocalDate dischargeDate;

    @Column(name = "Admission_Status", length = 20)
    private String admissionStatus = "Admitted";
}