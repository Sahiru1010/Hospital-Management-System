package org.example.hospital_management_system.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass //tells hibernate not to create a 'Person' table, but share these fields with child classes.
public abstract class Person {
    @Column(name = "Contact_Details", nullable = false, unique = true, length = 15)
    private String contactNumber;
}
