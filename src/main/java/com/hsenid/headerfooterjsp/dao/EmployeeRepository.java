package com.hsenid.headerfooterjsp.dao;


import com.hsenid.headerfooterjsp.model.Employee;
import com.hsenid.headerfooterjsp.model.EmployeeId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, EmployeeId> {

//    @Query(value = "select * FROM employee WHERE (YEAR(current_date) -YEAR(employee.joined_year) >= 5)",nativeQuery = true)
    @Query(value = "select e FROM Employee  e WHERE (YEAR(current_date) -YEAR(e.joinedYear) >= 5)")
    public abstract List<Employee> findEmployeeWorkedMoreThanFiveYear();

    @Query(value = "select e FROM Employee  e WHERE  e.nic like '90%'")
    public abstract List<Employee> findEmployeeNicStartWith90();

    @Query(value = "select e FROM Employee  e WHERE  ((YEAR(current_date) -YEAR(e.joinedYear) >= 5)) and (e.nic like '90%') ")
    public abstract List<Employee> findEmployeeWorkedMoreThanFiveYearNicStartWith90();


    @Query(value = "select e FROM Employee  e WHERE e.firstName= :name ")
    public abstract Employee viewEmployeeByName(@Param("name") String name);


//    @Query(value = "select e FROM Employee  e WHERE  e.department like '90%'")
    @Query(value = "select * FROM employee as e WHERE e.department_id = :dId ",nativeQuery = true)
    public abstract List<Employee> findEmployeesByDepartmetId(@Param("dId") long depatementId);

    @Query(value = "select * FROM employee  as e WHERE e.id= :id ",nativeQuery = true)
    public abstract Employee findEmployeeById(@Param("id") long id);


    @Modifying
    @Query("DELETE FROM Employee e WHERE e.id = :id")
    int deleteByEmployeeId(@Param("id") EmployeeId id);

    @Query(value = "select e.id FROM employee as e  order by e.id desc limit 1",nativeQuery = true)
    long getLastEmployeeId();

//    public Employee findEmployeeById(long id);
}
