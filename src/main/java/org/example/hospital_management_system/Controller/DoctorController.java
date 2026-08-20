package org.example.hospital_management_system.Controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.example.hospital_management_system.Entity.Doctor;
import org.example.hospital_management_system.Repository.DoctorRepo;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorRepo doctorRepo;
    public DoctorController(DoctorRepo doctorRepo) { this.doctorRepo = doctorRepo; }

    @PostMapping
    public Doctor addDoctor(@Valid @RequestBody DoctorDTO dto) {
        Doctor doc = new Doctor();
        doc.setDoctorId("DOC" + System.currentTimeMillis());
        doc.setDoctorName(dto.name);
        doc.setConsultationFee(dto.fee);
        doc.setContactNumber(dto.contact);
        doc.setDepartmentId(dto.departmentId);
        return doctorRepo.save(doc);
    }

    // Validation DTO[cite: 4]
    public static class DoctorDTO {
        @NotBlank(message = "Doctor name cannot be empty")
        public String name;
        @Positive(message = "Consultation fee must be greater than zero")
        public BigDecimal fee;
        @NotBlank
        public String contact;
        public String departmentId;
    }
}