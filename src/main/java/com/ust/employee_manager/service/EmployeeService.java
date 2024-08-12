package com.ust.employee_manager.service;

import com.ust.employee_manager.dto.EmployeeDto;
import com.ust.employee_manager.dto.ProjectDto;
import com.ust.employee_manager.model.Employee;
import com.ust.employee_manager.model.Project;
import com.ust.employee_manager.model.RegularEmployee;
import com.ust.employee_manager.model.TempEmployee;

public interface EmployeeService {


    public RegularEmployee createRegular(EmployeeDto employeeDto);

    public TempEmployee createTemp(EmployeeDto employeeDto);

    public Employee createProject(long empID,ProjectDto projectDto);

}
