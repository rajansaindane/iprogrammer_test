package com.rajan.iProgrammerTest.controller;

import com.rajan.iProgrammerTest.domain.Employee;
import com.rajan.iProgrammerTest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("save")
    public ResponseEntity<?> saveOrUpdate(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.saveOrUpdateEmployee(employee));
    }

    @GetMapping("employee_by_department/{departmentId}")
    public ResponseEntity<?> employeeByDepartment(@PathVariable("departmentId")Long departmentId){
        return ResponseEntity.ok(employeeService.getEmployeeCountByDepartment(departmentId));
    }

    @GetMapping("employee_by_city/{city}")
    public ResponseEntity<?> employeeByCity(@PathVariable("city")String city){
        return ResponseEntity.ok(employeeService.getEmployeeByCity(city));
    }

}
