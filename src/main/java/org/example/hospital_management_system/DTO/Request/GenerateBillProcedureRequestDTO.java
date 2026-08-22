package org.example.hospital_management_system.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillRequestDTO {
    @NotNull(message = "Bill date is required")
    private LocalDate billDate;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod;

    @NotBlank(message = "Patient ID is required")
    private String patientId;

    private BigDecimal docCharges;
    private BigDecimal roomCharges;
    private BigDecimal labCharges;
    private BigDecimal medCharges;
}
