package com.example.onetoone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;

@Data
@Transactional
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private Long empId;
    @Column(name="emp_name")
    private String empName;
    @Column(name="emp_age")
    private Integer empAge;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_add_id")
   // @JsonIgnore
    private Address address;
}
