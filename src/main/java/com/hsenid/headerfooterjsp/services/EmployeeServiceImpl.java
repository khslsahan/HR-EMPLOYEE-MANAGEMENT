package com.hsenid.headerfooterjsp.services;


import com.hsenid.headerfooterjsp.dao.DepartmentRepository;
import com.hsenid.headerfooterjsp.dao.EmployeeRepository;
import com.hsenid.headerfooterjsp.model.DepartmentName;
import com.hsenid.headerfooterjsp.model.Employee;
import com.hsenid.headerfooterjsp.model.EmployeeId;
import com.hsenid.headerfooterjsp.services.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class.getName());
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee viewEmployeeByName(String name) {
        return employeeRepository.viewEmployeeByName(name);
    }

    @Override
    public Employee findEmployeeById(long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartmentName(DepartmentName departmentName) {

        long departmentId =departmentRepository.getDepartmentIsByName(departmentName.getCode());
        return  employeeRepository.findEmployeesByDepartmetId(departmentId);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return (List<Employee>)employeeRepository.findAll() ;
    }

    @Override
    public Employee editEmployee(Employee employee, EmployeeId employeeId) {
        Employee empDB
                = employeeRepository.findById(employeeId)
                .get();

        if (Objects.nonNull(employee.getFirstName())
                && !"".equalsIgnoreCase(
                employee.getFirstName())) {
            empDB.setFirstName(
                    employee.getFirstName());
        }

        if (Objects.nonNull(employee.getLastName())
                && !"".equalsIgnoreCase(
                employee.getLastName())) {
            empDB.setLastName(
                    employee.getLastName());
        }

        if (Objects.nonNull(employee.getDepartment())) {
            empDB.setDepartment(
                    employee.getDepartment());
        }

        if (Objects.nonNull(employee.getNic())
                && !"".equalsIgnoreCase(
                employee.getNic())) {
            empDB.setNic(
                    employee.getNic());
        }

        if (Objects.nonNull(employee.getEmail())
                && !"".equalsIgnoreCase(
                employee.getEmail())) {
            empDB.setEmail(
                    employee.getEmail());
        }

        if (Objects.nonNull(employee.getMobilePhone())
                && !"".equalsIgnoreCase(
                employee.getMobilePhone())) {
            empDB.setMobilePhone(
                    employee.getMobilePhone());
        }

        if (Objects.nonNull(employee.getJoinedYear())) {
            empDB.setJoinedYear(
                    employee.getJoinedYear());
        }
        return employeeRepository.save(empDB);
    }


//    private <T> T getOrDefault(T value, T defaultValue) {
//        return Optional.ofNullable(value).orElse(defaultValue);
//    }
//
//    @Override
//    public Employee editEmployee(Employee employee, EmployeeId employeeId) {
//        Employee empDB = employeeRepository.findById(employeeId).orElseThrow();
//
//        empDB.setFirstName(getOrDefault(employee.getFirstName(), empDB.getFirstName()));
//        empDB.setLastName(getOrDefault(employee.getLastName(), empDB.getLastName()));
//        empDB.setDepartment(getOrDefault(employee.getDepartment(), empDB.getDepartment()));
//        empDB.setNic(getOrDefault(employee.getNic(), empDB.getNic()));
//        empDB.setEmail(getOrDefault(employee.getEmail(), empDB.getEmail()));
//        empDB.setMobilePhone(getOrDefault(employee.getMobilePhone(), empDB.getMobilePhone()));
//        empDB.setJoinedYear(getOrDefault(employee.getJoinedYear(), empDB.getJoinedYear()));
//
//        return employeeRepository.save(empDB);
//    }


    @Override
    public boolean deleteEmployeeById(EmployeeId employeeId) {
          try {
              employeeRepository.deleteById(employeeId);
              return true;
          }catch (Exception e){

              return false;
          }

    }

    @Override
    @Transactional
    public void deleteEmployeeByEmployeeId(long employeeId) {
        Employee employee = findEmployeeById(employeeId);
        employeeRepository.deleteByEmployeeId(employee.getId());
    }

    @Override
    public List<Employee> findEmployeeWorkedMoreThanFiveYear() {
        return  employeeRepository.findEmployeeWorkedMoreThanFiveYear();
    }

    @Override
    public List<Employee> findEmployeeNicStartWith90() {
        return  employeeRepository.findEmployeeNicStartWith90();
    }


    @Override
    public List<Employee> findEmployeeWorkedMoreThanFiveYearNicStartWith90() {
        return  employeeRepository.findEmployeeWorkedMoreThanFiveYearNicStartWith90();
    }

    @Override
    public long getLastEmployeeId() {
        return employeeRepository.getLastEmployeeId();
    }
}
