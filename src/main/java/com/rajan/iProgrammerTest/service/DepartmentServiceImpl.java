package com.rajan.iProgrammerTest.service;

import com.rajan.iProgrammerTest.domain.Department;
import com.rajan.iProgrammerTest.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        Department savedDepartment=departmentRepository.save(department);
        return savedDepartment;
    }
}
