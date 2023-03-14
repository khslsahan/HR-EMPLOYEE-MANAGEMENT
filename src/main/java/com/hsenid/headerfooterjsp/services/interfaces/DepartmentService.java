package com.hsenid.headerfooterjsp.services.interfaces;


import com.hsenid.headerfooterjsp.model.Department;
import com.hsenid.headerfooterjsp.model.DepartmentName;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    // Read operation
    List<Department> fetchDepartmentList();

    // Update operation
    Department updateDepartment(Department department,
                                Long departmentId);

    // Delete operation
    void deleteDepartmentById(Long departmentId);

    Department getDepartmentById(long departmentId);

    long getDepartmentIsByName(DepartmentName departmentName);

}
