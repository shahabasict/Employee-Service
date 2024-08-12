package com.ust.employee_manager.service;

import com.ust.employee_manager.dto.EmployeeDto;
import com.ust.employee_manager.dto.ProjectDto;
import com.ust.employee_manager.model.Employee;
import com.ust.employee_manager.model.Project;
import com.ust.employee_manager.model.RegularEmployee;
import com.ust.employee_manager.model.TempEmployee;
import com.ust.employee_manager.repository.EmployeeRepository;
import com.ust.employee_manager.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeserviceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public EmployeeserviceImpl(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public RegularEmployee createRegular(EmployeeDto employeeDto) {
        RegularEmployee regularEmployee = new RegularEmployee();
        regularEmployee.setName(employeeDto.name());
        regularEmployee.setEmail(employeeDto.email());
        regularEmployee.setAddresses(employeeDto.addresses());
        regularEmployee.setSalary(employeeDto.salary());
        regularEmployee.setBonus(employeeDto.bonus());
        return employeeRepository.save(regularEmployee);
    }

    @Override
    public TempEmployee createTemp(EmployeeDto employeeDto) {
        TempEmployee tempEmployee = new TempEmployee();
        tempEmployee.setName(employeeDto.name());
        tempEmployee.setEmail(employeeDto.email());
        tempEmployee.setAddresses(employeeDto.addresses());
        tempEmployee.setPerHour(employeeDto.perHour());
        tempEmployee.setWorkedHour(employeeDto.workedHour());
        return employeeRepository.save(tempEmployee);
    }

    @Override
    public Employee createProject(long empId,ProjectDto projectDto) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(()-> new RuntimeException("Employee Not Found"));
        Project project = new Project();
        project.setProjectName(projectDto.projectName());
        project.setStartDate(projectDto.startDate());

        employee.getProjects().add(project);
        projectRepository.save(project);

        return employeeRepository.save(employee);
    }
}
