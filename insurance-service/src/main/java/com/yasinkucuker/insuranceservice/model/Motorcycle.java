package com.yasinkucuker.insuranceservice.model;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Motorcycle extends Vehicle {
    private double enginePower;

    public Motorcycle(){

    }
    public Motorcycle(double enginePower) {
        this.enginePower = enginePower;
    }

    public Motorcycle(String model, String plate, int year, double enginePower) {
        super(model, plate, year);
        this.enginePower = enginePower;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Motorcycle that = (Motorcycle) o;
        return Double.compare(enginePower, that.enginePower) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), enginePower);
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "enginePower=" + enginePower +
                '}';
    }
}
