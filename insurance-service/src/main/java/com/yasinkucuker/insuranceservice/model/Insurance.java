package com.yasinkucuker.insuranceservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private double insuranceAmount;
    private LocalDate insuranceExpiryDate;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Vehicle vehicle;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
