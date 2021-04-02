package com.rajan.iProgrammerTest.service;

import com.rajan.iProgrammerTest.domain.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee saveOrUpdateEmployee(Employee employee);
    Map<String,Object> getEmployeeCountByDepartment(Long departmentId);
    Map<String,Object> getEmployeeByCity(String city);
}
