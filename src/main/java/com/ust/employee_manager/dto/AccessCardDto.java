package com.ust.employee_manager.dto;

import java.time.LocalDate;

public record AccessCardDto(
        double accId,
        LocalDate issuedate,
        String accessCode
) {
}
