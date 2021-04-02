package com.rajan.iProgrammerTest.service;

import com.rajan.iProgrammerTest.domain.Department;
import com.rajan.iProgrammerTest.domain.Employee;
import com.rajan.iProgrammerTest.repository.DepartmentRepository;
import com.rajan.iProgrammerTest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Map<String, Object> saveOrUpdateEmployee(Employee employee) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (employee.getEmployeeId() != null) {
                employee.setUpdatedAt(new Date());
            }
            Employee savedEmployee = employeeRepository.save(employee);
            map.put("status", "success");
            map.put("result", savedEmployee);
        } catch (Exception e) {
            map.put("status", "fail");
        }
        return map;
    }

    @Override
    public Map<String, Object> getEmployeeCountByDepartment(Long departmentId) {
        Map<String, Object> map = new HashMap<>();
        try {
            Department checkDepartment = departmentRepository.findById(departmentId).get();
            if (checkDepartment != null) {
                map.put("status", "success");
                map.put("employees", employeeRepository.getEmployeeCountByDepartment(departmentId));
            }
        } catch (Exception e) {
            map.put("status", "fail");
            map.put("message", "Invalid Department Id");
        }
        return map;
    }

    @Override
    public Map<String, Object> getEmployeeByCity(String city) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Employee> employees = employeeRepository.findByCity(city);
            if (employees != null && !employees.isEmpty()) {
                map.put("status", "success");
                map.put("result", employees);
                map.put("count", employees.size());
            } else {
                map.put("status", "success");
                map.put("message", "City cannot found");
            }

        } catch (Exception e) {
            map.put("status", "fail");
            map.put("message", "Invalid City");
        }
        return map;
    }
}
