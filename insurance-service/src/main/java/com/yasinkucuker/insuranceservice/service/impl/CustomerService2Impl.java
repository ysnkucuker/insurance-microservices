package com.yasinkucuker.insuranceservice.service.impl;

import com.yasinkucuker.insuranceservice.exception.CustomerNotFoundException;
import com.yasinkucuker.insuranceservice.model.Customer;
import com.yasinkucuker.insuranceservice.model.dto.CustomerDTO;
import com.yasinkucuker.insuranceservice.repository.CustomerRepository;
import com.yasinkucuker.insuranceservice.service.CustomerService;

import java.util.List;

public class CustomerService2Impl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService2Impl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomer(long id) {
        return null;
    }

    @Override
    public Customer findCustomerById(long id) {
        System.out.println("Customer Service2");
        // Optional olduğu için dönmesse kontrol de yapıyoruz.
        // Kendi exceptionımızı yazıyoruz.
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID : " + id));
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        return null;
    }

    @Override
    public Customer findCustomerBySsid(long ssid) {
        return customerRepository.findCustomerBySsid(ssid);
    }

    @Override
    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        return customerRepository.findCustomerByPhoneNumber(phoneNumber);
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void deleteCustomer(long id) {

    }
}
