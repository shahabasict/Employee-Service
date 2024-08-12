package com.ust.employee_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long projectId;
    private String projectName;
    private LocalDate startDate;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employee;

}
