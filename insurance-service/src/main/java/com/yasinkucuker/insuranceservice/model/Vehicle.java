package com.yasinkucuker.insuranceservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.TABLE) Hoca SEQUENCE önerdi
    private long id;
    private String model;
    private String plate;
    private int year;

    // Assoc
    // 1'e 1 (1 aracın sadece 1 müşterisi olabilir)
    @JsonBackReference
    @ManyToOne
    private Customer customer;
    // 1 araç 1'den fazla kazaya karışabilir.
    @ManyToMany
    private Set<Accident> accidents = new HashSet<>();


    public Vehicle() {
    }

    public Vehicle(String model, String plate, int year) {
        this.model = model;
        this.plate = plate;
        this.year = year;
    }

    public Vehicle(long id, String model, String plate, int year, Customer customer, Set<Accident> accidents) {
        this.id = id;
        this.model = model;
        this.plate = plate;
        this.year = year;
        this.customer = customer;
        this.accidents = accidents;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(Set<Accident> accidents) {
        this.accidents = accidents;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(plate, vehicle.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plate);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", plate='" + plate + '\'' +
                ", year=" + year +
                '}';
    }
}
