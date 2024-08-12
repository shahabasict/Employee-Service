package com.ust.employee_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "access",uniqueConstraints = @UniqueConstraint(columnNames = "accessCode"))
public class AccessCard {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private double accId;
    private LocalDate issuedate;
    private String accessCode;

    @OneToOne(mappedBy = "accessCard")
    private Employee employee;

}
