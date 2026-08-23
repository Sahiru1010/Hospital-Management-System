package org.example.hospital_management_system.Service;

import org.example.hospital_management_system.Entity.Department;
import org.example.hospital_management_system.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired private DepartmentRepo departmentRepo;

    public List<Department> getAllDepartments() { return departmentRepo.findAll(); }
    public Optional<Department> getDepartmentById(String id) { return departmentRepo.findById(id); }
    public Department saveDepartment(Department department) { return departmentRepo.save(department); }
    public void deleteDepartment(String id) { departmentRepo.deleteById(id); }
    public List<Department> searchByDepartmentName(String name) { return departmentRepo.findByDepartmentNameContaining(name); }
}
