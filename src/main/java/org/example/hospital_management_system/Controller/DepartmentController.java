package org.example.hospital_management_system.Controller;

import org.example.hospital_management_system.Entity.Department;
import org.example.hospital_management_system.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//REST Controller for managing Hospital Departments
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired private DepartmentService departmentService;

    //Update Patient Details
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String id, @RequestBody Department updatedDepartment) {
        return departmentService.getDepartmentById(id).map(existingPatient -> {
            updatedDepartment.setDepartmentId(id); // Ensure the ID doesn't change
            return ResponseEntity.ok(departmentService.saveDepartment(updatedDepartment));
        }).orElse(ResponseEntity.notFound().build());
    }

    //SEARCH (Search by Name)
    @GetMapping("/search")
    public ResponseEntity<List<Department>> searchDepartments(@RequestParam String name) {
        return ResponseEntity.ok(departmentService.searchByDepartmentName(name));
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll() { return ResponseEntity.ok(departmentService.getAllDepartments()); }

    @PostMapping
    public ResponseEntity<Department> create(@RequestBody Department department) { return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED); }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) { departmentService.deleteDepartment(id); return ResponseEntity.ok("Deleted successfully"); }
}
