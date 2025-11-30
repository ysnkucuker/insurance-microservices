package com.yasinkucuker.insuranceservice.service;

import com.yasinkucuker.insuranceservice.model.Customer;
import com.yasinkucuker.insuranceservice.model.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    Customer findCustomer(long id);
    Customer findCustomerById(long id);
    List<CustomerDTO> findAllCustomers();
    Customer findCustomerBySsid(long ssid);

    Customer findCustomerByPhoneNumber(String phoneNumber);

    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    void deleteCustomer(long id);

}
