package com.ust.employee_manager.controller;

import com.ust.employee_manager.dto.EmployeeDto;
import com.ust.employee_manager.dto.ProjectDto;
import com.ust.employee_manager.model.Employee;
import com.ust.employee_manager.model.RegularEmployee;
import com.ust.employee_manager.model.TempEmployee;
import com.ust.employee_manager.repository.EmployeeRepository;
import com.ust.employee_manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("regular/create")
    public ResponseEntity<RegularEmployee> createRegEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.createRegular(employeeDto));
    }

    @PostMapping("/temp/create")
    public ResponseEntity<TempEmployee> createTempEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.createTemp(employeeDto));
    }

    @PostMapping("/employees/{empId}/projects")
    public ResponseEntity<Employee> createProject(@PathVariable long empId, @RequestBody ProjectDto projectDto){
        Employee employee = employeeService.createProject(empId,projectDto);
        return ResponseEntity.ok(employee);
    }

}
