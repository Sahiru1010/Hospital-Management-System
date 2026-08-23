package org.example.hospital_management_system.Repository;
import org.example.hospital_management_system.Entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepo extends JpaRepository<Admission, String> { }