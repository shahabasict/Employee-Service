package com.ust.employee_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Employee",
uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long empId;
    private String name;
    private String email;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Address> addresses;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "access_id",referencedColumnName = "accId")
    private AccessCard accessCard;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "empProj",joinColumns = {@JoinColumn(name = "emp_ID")},inverseJoinColumns = {@JoinColumn(name = "project_Id")})
    private Set<Project> projects;


}
