package org.example.hospital_management_system.DTO.Response;

import lombok.Data;
import java.math.BigDecimal;

public class DoctorResponseDTO {
    private String doctorId;
    private String doctorName;
    private String specialization;
    private BigDecimal consultationFee;
    private String departmentId;
}
