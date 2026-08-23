package org.example.hospital_management_system.Repository;

import org.example.hospital_management_system.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String> {

    List<Department> findByDepartmentNameContaining(String name);
}

