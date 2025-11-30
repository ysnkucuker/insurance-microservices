package com.yasinkucuker.insuranceservice.repository;

import com.yasinkucuker.insuranceservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository  // Standaert sql hatalarını özelleştiriyor.
//CrudRepository extend eder (save, delete, find, findall)
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //
    //@Query(value = "SELECT * FROM customer c WHERE c.ssid_number = ?1" , nativeQuery = true)
    @Query(value = "SELECT c FROM Customer c WHERE c.ssidNumber = :ssid")
    Customer findCustomerBySsid(long ssid);

    //@Query(value = "SELECT * FROM customer c WHERE c.phone_number = ?1", nativeQuery = true)
    //@Query(value = "SELECT c FROM Customer c WHERE c.phoneNumber = :phoneNumber")
    // Method Driven Query
    Customer findCustomerByPhoneNumber(String phoneNumber);
    Customer findCustomerByAddressAndSsidNumber(String address, long ssid);
    

}
