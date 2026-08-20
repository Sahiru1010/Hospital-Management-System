package org.example.hospital_management_system.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class DoctorRequestDTO {
    @NotBlank (message = "Doctor ID is required")
    private String doctorId;

    @NotBlank(message = "Doctor Name cannot be empty")
    private String doctorName;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    @NotBlank(message = "Qualification is required")
    private String qualification;

    @NotBlank(message = "Contact Number is required")
    private String contactNumber;

    @NotNull(message = "Consultation Fee is required")
    @Positive(message = "Consultation fee must be grater than zero")
    private BigDecimal consultationFee;

    @NotBlank(message = "Department ID is required")
    private String departmentId;
}
