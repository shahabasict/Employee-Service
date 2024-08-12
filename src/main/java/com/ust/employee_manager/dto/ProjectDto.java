package com.ust.employee_manager.dto;

import java.time.LocalDate;

public record ProjectDto(
        long projectId,
        String projectName,
        LocalDate startDate
) {
}
