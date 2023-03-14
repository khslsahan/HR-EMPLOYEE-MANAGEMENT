package com.hsenid.headerfooterjsp.services.interfaces;


import com.hsenid.headerfooterjsp.model.DepartmentName;
import com.hsenid.headerfooterjsp.model.Employee;
import com.hsenid.headerfooterjsp.model.EmployeeId;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee );

    Employee viewEmployeeByName(String name);

    Employee findEmployeeById(long id);

    List<Employee> getEmployeesByDepartmentName(DepartmentName departmentName);

    // Read operation
    List<Employee> fetchEmployeeList();

    // Update operation
    Employee editEmployee(Employee  employee,
                          EmployeeId employeeId);

    // Delete operation
    boolean deleteEmployeeById(EmployeeId employeeId);

    List<Employee> findEmployeeWorkedMoreThanFiveYear();

    List<Employee> findEmployeeNicStartWith90();

    List<Employee> findEmployeeWorkedMoreThanFiveYearNicStartWith90();

    void deleteEmployeeByEmployeeId(long employeeId);

    long getLastEmployeeId();
}
