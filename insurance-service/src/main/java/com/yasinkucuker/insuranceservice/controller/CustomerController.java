package com.yasinkucuker.insuranceservice.controller;

import com.yasinkucuker.insuranceservice.model.Customer;
import com.yasinkucuker.insuranceservice.model.dto.CustomerDTO;
import com.yasinkucuker.insuranceservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    //@Qualifier(value = "CustomerService2Impl")
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping("/customers")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }

    // End Point
    //@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    @GetMapping("/customers/{id}")
    //public ResponseEntity<Customer> findCustomerById(@PathVariable long id)
    public Customer findCustomerById(@PathVariable long id){
        return customerService.findCustomerById(id);
    }

    @GetMapping("/customers")
    public List<CustomerDTO> findAllCustomers(){return customerService.findAllCustomers();}

    @GetMapping("/customers/ssid")
    public Customer findCustomerBySsid(@RequestParam long ssid) {
        return customerService.findCustomerBySsid(ssid);
    }

    @GetMapping("/customers/phone-number")
    public Customer findCustomerByPhoneNumber(String phoneNumber){return customerService.findCustomerByPhoneNumber(phoneNumber);}
}
