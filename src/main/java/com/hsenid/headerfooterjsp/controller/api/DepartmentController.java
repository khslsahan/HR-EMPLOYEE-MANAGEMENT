package com.hsenid.headerfooterjsp.controller.api;


import com.hsenid.headerfooterjsp.model.Department;
import com.hsenid.headerfooterjsp.model.DepartmentName;
import com.hsenid.headerfooterjsp.services.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;




    @GetMapping("/department")
    private ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.fetchDepartmentList();
        return ResponseEntity.ok().body(departments);
    }


//    @GetMapping("/department/id")
//    private  Department getDepartmentsById(@RequestParam long  departmentId){
//        return departmentService.getDepartmentById(departmentId);
//    }

    @GetMapping("/department/id")
    private ResponseEntity<?> getDepartmentsById(@RequestParam long departmentId) {
        try {
            Department department = departmentService.getDepartmentById(departmentId);
            return ResponseEntity.ok(department);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }


//    @GetMapping("/department/name")
//    private  Department getDepartmentsById(@RequestParam String departmentName){
//        long id = departmentService.getDepartmentIsByName(DepartmentName.valueOf(departmentName));
//        return departmentService.getDepartmentById(id);
//    }


    @GetMapping("/department/name")
    private ResponseEntity<Department> getDepartmentByName(@RequestParam String departmentName) {
        try {
            DepartmentName department = DepartmentName.valueOf(departmentName);
            long id = departmentService.getDepartmentIsByName(department);
            Department departmentById = departmentService.getDepartmentById(id);
            return ResponseEntity.ok(departmentById);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


//    @PostMapping("/department")
//    public Department saveDepartment(@RequestBody Department department){
//        return departmentService.saveDepartment(department);
//    }


    @PostMapping("/department")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        try {
            Department savedDepartment = departmentService.saveDepartment(department);
            return ResponseEntity.ok(savedDepartment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


//    @PutMapping("/department")
//    public Department updateDepartment(@RequestBody Department department){
//        return departmentService.updateDepartment(department,department.getId());
//    }



    @PutMapping("/department")
    public ResponseEntity<String> updateDepartment(@RequestBody Department department) {
        try {
            departmentService.updateDepartment(department, department.getId());
            return ResponseEntity.ok("Department updated successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating department");
        }
    }


//    @DeleteMapping("/department/{id}")
//    private  String deleteDepartment(@PathVariable long id){
//        System.out.println("here");
//         departmentService.deleteDepartmentById(id);
//         return  "Department  Deleted";
//    }

    @DeleteMapping("/department/{id}")
    private ResponseEntity<String> deleteDepartment(@PathVariable long id) {
        try {
            departmentService.deleteDepartmentById(id);
            return ResponseEntity.ok("Department deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the department");
        }
    }


}
