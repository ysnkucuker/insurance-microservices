package com.yasinkucuker.insuranceservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// POJO
@Entity
@Builder
@AllArgsConstructor
public class Customer {
    // Variables-Members-Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private String address;
    private long ssidNumber;
    private String phoneNumber;

    // Assoc
    // 1'e Çok (Bir müşterinin 1'den çok aracı olabilir)
    @JsonManagedReference
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
     private List<Vehicle> vehicleList = new ArrayList<>();

    // Constructors
    public Customer() {
    }

    public Customer(String fullName, String address, long ssidNumber, String phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.ssidNumber = ssidNumber;
        this.phoneNumber = phoneNumber;
    }

    // Custom Methods
    // Getters & Setters

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

    public long getSsidNumber() {
        return ssidNumber;
    }

    public void setSsidNumber(long ssidNumber) {
        this.ssidNumber = ssidNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // @JsonIgnore Sonsuz döngüye girmemesi için
    public List<Vehicle> getVehicleList() {
        if (vehicleList == null) {
            return new ArrayList<>();  // Eğer null ise boş bir liste döndür
        }
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    // Object Metodları
    // toString - equlas & hashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return ssidNumber == customer.ssidNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssidNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", ssidNumber=" + ssidNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
