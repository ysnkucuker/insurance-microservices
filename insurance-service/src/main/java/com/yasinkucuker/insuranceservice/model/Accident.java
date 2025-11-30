package com.yasinkucuker.insuranceservice.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate accidentDate;

    //Assoc
    //1 kazaya 1den fazla araç karışabilir.
    @ManyToMany(mappedBy = "accidents")
    private Set<Vehicle> vehicleList = new HashSet<>();

    public Accident() {
    }

    public Accident(long id, LocalDate accidentDate, Set<Vehicle> vehicleList) {
        this.id = id;
        this.accidentDate = accidentDate;
        this.vehicleList = vehicleList;
    }

    public Accident(LocalDate accidentDate) {
        this.accidentDate = accidentDate;
    }

    public LocalDate getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(LocalDate accidentDate) {
        this.accidentDate = accidentDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accident accident = (Accident) o;
        return Objects.equals(accidentDate, accident.accidentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accidentDate);
    }

    @Override
    public String toString() {
        return "Accident{" +
                "accidentDate=" + accidentDate +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
