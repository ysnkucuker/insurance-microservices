package com.yasinkucuker.insuranceservice.model.dto;

import com.yasinkucuker.insuranceservice.model.enums.VehicleType;

public class VehicleDTO {
    private long id;
    private String model;
    private String plate;
    private int year;

    private VehicleType vehicleType;

    public VehicleDTO() {
    }

    public VehicleDTO(long id, String model, String plate, int year, VehicleType vehicleType) {
        this.id = id;
        this.model = model;
        this.plate = plate;
        this.year = year;
        this.vehicleType = vehicleType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", plate='" + plate + '\'' +
                ", year=" + year +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
