package com.example.onetoone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;

@Data
@Transactional
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="add_id")
    private Long addressId;
    @Column(name="city")
    private String city;
    @Column(name="add_type")
    private String addressType;
    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Employee employee;
}
