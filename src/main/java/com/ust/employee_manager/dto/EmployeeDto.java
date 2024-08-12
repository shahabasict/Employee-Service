package com.ust.employee_manager.dto;

import com.ust.employee_manager.model.AccessCard;
import com.ust.employee_manager.model.Address;
import com.ust.employee_manager.model.Project;

import java.util.List;
import java.util.Set;

public record EmployeeDto(
        String name,
        String email,
        List<Address> addresses,
        double salary,
        double bonus,
        double perHour,
        double workedHour

) {
}
