package com.yasinkucuker.insuranceservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private long id;
    private String fullName;
    private String address;
    private String ssidNumber;
    private String phoneNumber;
    private List<VehicleDTO> vehicleList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSsidNumber() {
        return ssidNumber;
    }

    public void setSsidNumber(String ssidNumber) {
        this.ssidNumber = ssidNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<VehicleDTO> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<VehicleDTO> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", ssidNumber=" + ssidNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", vehicleList=" + vehicleList +
                '}';
    }
}
