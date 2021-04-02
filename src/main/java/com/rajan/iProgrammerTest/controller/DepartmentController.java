package com.rajan.iProgrammerTest.controller;

import com.rajan.iProgrammerTest.domain.Department;
import com.rajan.iProgrammerTest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/department/")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody Department department){
        Map<String,Object> map=new HashMap<>();
        try {
            map.put("status","success");
            map.put("result",departmentService.saveDepartment(department));
        }
        catch (Exception e){
            map.put("status","fail");
        }
        return ResponseEntity.ok(map);
    }
}
