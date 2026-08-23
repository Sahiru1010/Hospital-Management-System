package org.example.hospital_management_system.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "DOCTOR")

@AttributeOverride(name = "contactNumber", column = @Column(name = "Contact_Number", nullable = false, unique = true, length = 15))
@Data

public class Doctor extends Person{
    @Id
    @Column(name = "Doctor_ID", length = 20)
    private String doctorId;

    @Column(name = "Doctor_Name", nullable = false, length = 100)
    private String doctorName;

    @Column(name = "Specialization", nullable = false, length = 100)
    private String specialization;

    @Column(name = "Qualification", nullable = false, length = 100)
    private String qualification;

    @Column(name = "Consultation_Fee", nullable = false)
    private BigDecimal consultationFee;

    @Column(name = "Department_ID", nullable = false, length = 20)
    private String departmentId;

}
