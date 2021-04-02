package com.rajan.iProgrammerTest.repository;


import com.rajan.iProgrammerTest.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT COUNT(employee_id) from employee where department_id = :departmentId",nativeQuery = true)
    Long getEmployeeCountByDepartment(@Param("departmentId") Long departmentId);

    List<Employee> findByCity(String city);
}
