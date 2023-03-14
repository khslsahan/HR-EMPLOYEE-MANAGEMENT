package com.hsenid.headerfooterjsp.dao;

import com.hsenid.headerfooterjsp.model.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository  extends CrudRepository<Department,Long> {

    @Query(value = "select id from department where  department.name= :departmentName " ,nativeQuery = true)
    long getDepartmentIsByName(@Param("departmentName") String departmentName);

}