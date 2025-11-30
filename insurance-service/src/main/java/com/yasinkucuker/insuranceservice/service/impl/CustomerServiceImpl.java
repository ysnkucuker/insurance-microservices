package com.yasinkucuker.insuranceservice.service.impl;


import com.yasinkucuker.insuranceservice.exception.CustomerNotFoundException;
import com.yasinkucuker.insuranceservice.mapper.CustomerDTOCustomerEntityMapper;
import com.yasinkucuker.insuranceservice.mapper.CustomerEntityCustomerDTOMapper;
import com.yasinkucuker.insuranceservice.model.Customer;
import com.yasinkucuker.insuranceservice.model.dto.CustomerDTO;
import com.yasinkucuker.insuranceservice.repository.CustomerRepository;
import com.yasinkucuker.insuranceservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerEntityCustomerDTOMapper customerEntityCustomerDTOMapper;
    private final CustomerDTOCustomerEntityMapper customerDTOCustomerEntityMapper;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerEntityCustomerDTOMapper customerEntityCustomerDTOMapper, CustomerDTOCustomerEntityMapper customerDTOCustomerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityCustomerDTOMapper = customerEntityCustomerDTOMapper;
        this.customerDTOCustomerEntityMapper = customerDTOCustomerEntityMapper;
    }

    @Override
    public Customer findCustomer(long id) {
        System.out.println("Inside CustomerServiceImpl");
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID : " + id));
    }

    @Override
    public Customer findCustomerById(long id) {
        System.out.println("Inside CustomerService");
        // Optional olduğu için dönmesse kontrol de yapıyoruz.
        // Kendi exceptionımızı yazıyoruz.
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID : " + id));
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        customerList.stream().forEach(c -> customerDTOList.add(customerEntityCustomerDTOMapper.map(c, null)));
        return customerDTOList;
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
        Customer customer = customerDTOCustomerEntityMapper.map(customerDTO);
        return customerEntityCustomerDTOMapper.map(customerRepository.save(customer));
    }

    @Override
    public void deleteCustomer(long id) {
        Customer foundCustomer = findCustomerById(id);
        customerRepository.delete(foundCustomer);
    }
}
