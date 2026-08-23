package org.example.hospital_management_system.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PATIENT")

@Data
public class Patient extends Person {
    @Id
    @Column(name = "Patient_ID", length = 20)
    private String patientId;

    @Column(name = "Full_Name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "DOB", nullable = false)
    private LocalDate dob;

    @Column(name = "Gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Blood_Group", nullable = false, length = 5)
    private String bloodGroup;

    @Column(name = "Emergency_Contact", nullable = false, length = 15)
    private String emergencyContact;
}

