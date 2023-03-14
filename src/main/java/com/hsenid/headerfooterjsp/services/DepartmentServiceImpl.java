package com.hsenid.headerfooterjsp.services;

import com.hsenid.headerfooterjsp.dao.DepartmentRepository;
import com.hsenid.headerfooterjsp.model.Department;
import com.hsenid.headerfooterjsp.model.DepartmentName;
import com.hsenid.headerfooterjsp.services.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl  implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return (List<Department>)departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {
        Department depDB
                = departmentRepository.findById(departmentId)
                .get();

        if (Objects.nonNull(department.getName())
                && !"".equalsIgnoreCase(
                department.getName().getCode())) {
            depDB.setName(
                    department.getName());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department getDepartmentById(long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public long getDepartmentIsByName(DepartmentName departmentName) {
        return departmentRepository.getDepartmentIsByName(departmentName.getCode());
    }
}
