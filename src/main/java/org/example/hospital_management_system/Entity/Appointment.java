package org.example.hospital_management_system.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "APPOINTMENT")
@Data
public class Appointment {

    //Primary Key
    @Id
    @Column(name = "Appointment_ID", length = 20)
    private String appointmentId;

    //Association to Patient
    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    //Association to Doctor
    @ManyToOne
    @JoinColumn(name = "Doctor_ID", nullable = false)
    private Doctor doctor;

    @Column(name = "Appointment_Date", nullable = false)
    private LocalDate appointmentDate;

    @Column(name = "Appointment_Time", nullable = false)
    private LocalTime appointmentTime;

    @Column(name = "Consultation_Room", length = 50)
    private String consultationRoom;

    @Column(name = "Appointment_Status", length = 20)
    private String appointmentStatus = "Scheduled";
}