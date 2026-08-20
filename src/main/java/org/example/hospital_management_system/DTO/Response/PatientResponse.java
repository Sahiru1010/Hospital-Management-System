package org.example.hospital_management_system.DTO.Response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientResponse {
    private String patientId;
    private String fullName;
    private LocalDate dob;
    private String contactNumber;
    private String gender;
    private String address;
    private String bloodGroup;
    private String emergencyContact;
}
