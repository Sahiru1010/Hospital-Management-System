package org.example.hospital_management_system.DTO.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;


@Data
public class PatientRequest {
    @NotBlank(message = "Patient ID is required")
    private String patientId;

    @NotBlank(message = "Full Name is required")
    private String fullName;

    @NotNull(message = "Date of Birth is required")
    private LocalDate dob;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Need a valid contact number")
    private String contactNumber;

    @NotBlank(message = "Blood Group is required")
    private String bloodGroup;

    @NotBlank(message = "Emergency Contact is required")
    private String emergencyContact;
}