package org.example.hospital_management_system.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DEPARTMENT")
@Data
public class Department {
    @Id
    @Column(name = "Department_ID", length = 20)
    private String departmentId;

    @Column(name = "Department_Name", nullable = false, unique = true, length = 100)
    private String departmentName;

    @Column(name = "Location", nullable = false, length = 100)
    private String location;

    @Column(name = "Head_Doctor_ID", length = 20)
    private String headDoctorId;
}
