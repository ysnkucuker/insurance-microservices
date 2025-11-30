package com.yasinkucuker.insuranceservice.model;


import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Car extends Vehicle {
    private String color;

    public Car(){

    }
    public Car(String color) {
        this.color = color;
    }

    public Car(String model, String plate, int year, String color) {
        super(model, plate, year);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                '}';
    }
}
