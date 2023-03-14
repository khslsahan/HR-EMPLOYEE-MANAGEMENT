package com.hsenid.headerfooterjsp.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hsenid.headerfooterjsp.model.Employee;
import com.hsenid.headerfooterjsp.model.EmployeeId;
import com.hsenid.headerfooterjsp.services.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

   @Autowired
   EmployeeService employeeService;



    @GetMapping("/employee")
    private ResponseEntity<List<Employee>> getAllEmployees()  {
        try {
            List<Employee> employeeList = employeeService.fetchEmployeeList();
            if (employeeList != null && !employeeList.isEmpty()) {
                return ResponseEntity.ok(employeeList);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            // Handle or re-throw the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/employee/name")
    public ResponseEntity<Employee> getEmployeeByFirstName(@RequestParam String firstName) {
        try {
            Employee employee = employeeService.viewEmployeeByName(firstName);
            if (employee != null) {
                return ResponseEntity.ok(employee);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        try {
            Employee employee = employeeService.findEmployeeById(id);
            if (employee != null) {
                return ResponseEntity.ok(employee);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    @PostMapping("/employee")
//    private Employee addEmployee(@RequestBody Employee employee){
//        return employeeService.addEmployee(employee);
//    }


    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        try {
            Employee addedEmployee = employeeService.addEmployee(employee);
            return ResponseEntity.created(URI.create("/employees/" + addedEmployee.getId()))
                    .body(addedEmployee);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


//    @PutMapping("/employee")
//    private Employee updateEmployee(@RequestBody Employee employee){
//        return employeeService.editEmployee(employee, employee.getId());
//    }


    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(  @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.editEmployee(employee, employee.getId());
            if (updatedEmployee != null) {
                return ResponseEntity.ok(updatedEmployee);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


//    @DeleteMapping("/employee")
//    private String deleteEmployee(@RequestBody EmployeeId employeeId){
//        employeeService.deleteEmployeeById(employeeId);
//        return "Deletion Success";
//    }

    @DeleteMapping("/employees")
    public ResponseEntity<Void> deleteEmployee(@RequestBody EmployeeId employeeId) {
        try {
            boolean deleted = employeeService.deleteEmployeeById(employeeId);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
