package com.ust.employee_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addres")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long addId;
    private String place;
    private String State;

    @ManyToOne
    @JoinColumn(name = "emp_id",referencedColumnName = "empId")
    private Employee employee;
}
